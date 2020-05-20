package com.example.myapplication.comment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.comment.bean.CommonCommentVoResponseVo;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentExpandAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "CommentExpandAdapter";
    private List<CommonCommentVoResponseVo> commentBeanList;
    private Context context;

    public CommentExpandAdapter(Context context, List<CommonCommentVoResponseVo> commentBeanList) {
        this.context = context;
        this.commentBeanList = commentBeanList;
    }

    /**
     * getGroupCount，返回group分组的数量，在当前需求中指代评论的数量
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        if (commentBeanList==null ||commentBeanList.size()==0 ){
            return 0;
        }
        return commentBeanList.size();
    }


    /**
     * getChildrenCount，返回所在group中child的数量，这里指代当前评论对应的回复数目。
     *
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        if(commentBeanList.get(groupPosition).getCommentReplys()==null || commentBeanList.get(groupPosition).getCommentReplys().size()==0){
            return 0;
        }
        return commentBeanList.get(groupPosition).getCommentReplys().size();
    }

    /**
     * getGroup，返回group的实际数据，这里指的是当前评论数据。
     *
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return commentBeanList.get(groupPosition);
    }

    /**
     * getChild，返回group中某个child的实际数据，这里指的是当前评论的某个回复数据。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if(commentBeanList.get(groupPosition).getCommentReplys()==null){
            return  null;
        }
        return commentBeanList.get(groupPosition).getCommentReplys().get(childPosition);
    }

    /**
     * getGroupId，返回分组的id，一般将当前group的位置传给它。
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * getChildId，返回分组中某个child的id，一般也将child当前位置传给它，不过为了避免重复，可以使用getCombinedChildId(groupPosition, childPosition);来获取id并返回
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getCombinedChildId(groupPosition, childPosition);
    }

    /**
     * hasStableIds，表示分组和子选项是否持有稳定的id，这里返回true即可。
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * getGroupView，即返回group的视图，一般在这里进行一些数据和视图绑定的工作，一般为了复用和高效，可以自定义ViewHolder，用法与listview一样，这里就不多说了。
     *
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    boolean isLike = false;
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final GroupHolder groupHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item_layout, parent, false);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        Glide.with(context).load(commentBeanList.get(groupPosition).getFromUserHeadImg())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .into(groupHolder.logo);
        groupHolder.tv_name.setText(commentBeanList.get(groupPosition).getFromUserNickName());
        groupHolder.tv_time.setText(commentBeanList.get(groupPosition).getDurTimeformate());
        groupHolder.tv_content.setText(commentBeanList.get(groupPosition).getContent());
        groupHolder.iv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLike){
                    isLike = false;
                    groupHolder.iv_like.setColorFilter(Color.parseColor("#aaaaaa"));
                }else {
                    isLike = true;
                    groupHolder.iv_like.setColorFilter(Color.parseColor("#FF5C5C"));
                }
            }
        });
        return convertView;
    }

    /**
     * getChildView，返回分组中child子项的视图，比较容易理解，第一个参数是当前group所在的位置，第二个参数是当前child所在位置。
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildHolder childHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout, parent, false);
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        String replyUser = commentBeanList.get(groupPosition).getCommentReplys().get(childPosition).getFromUserNickName();
        childHolder.tv_name.setText(replyUser + ":");
        childHolder.tv_content.setText(commentBeanList.get(groupPosition).getCommentReplys().get(childPosition).getContent());
        return convertView;
    }

    /**
     * isChildSelectable，表示分组中的child是否可以选中，这里返回true。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    private class GroupHolder {
        private CircleImageView logo;
        private TextView tv_name, tv_content, tv_time;
        private ImageView iv_like;

        public GroupHolder(View view) {
            logo = view.findViewById(R.id.comment_item_logo);
            tv_content = view.findViewById(R.id.comment_item_content);
            tv_name = view.findViewById(R.id.comment_item_userName);
            tv_time = view.findViewById(R.id.comment_item_time);
            iv_like = view.findViewById(R.id.comment_item_like);
        }
    }

    private class ChildHolder {
        private TextView tv_name, tv_content;

        public ChildHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.reply_item_user);
            tv_content = (TextView) view.findViewById(R.id.reply_item_content);
        }
    }
}
