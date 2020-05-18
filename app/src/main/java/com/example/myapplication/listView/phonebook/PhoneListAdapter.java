package com.example.myapplication.listView.phonebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class PhoneListAdapter extends BaseAdapter implements SectionIndexer {

    private Context context;
    private List<User> userList;

    public PhoneListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_phone, parent, false);
            viewHolder.username = convertView.findViewById(R.id.username);
            viewHolder.showLetter = convertView.findViewById(R.id.show_letter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User user = userList.get(position);
        viewHolder.username.setText(user.getUsername());
        int sectionForPosition = getSectionForPosition(position);
        //获得该分组第一项的position
        int positionForSection = getPositionForSection(sectionForPosition);
        //查看当前position是不是当前item所在分组的第一个item
        //如果是，则显示showLetter，否则隐藏
        if (position == positionForSection) {
            viewHolder.showLetter.setVisibility(View.VISIBLE);
            viewHolder.showLetter.setText(user.getFirstLetter());
        } else {
            viewHolder.showLetter.setVisibility(View.GONE);
        }
        return convertView;
    }


    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    /**
     * //传入一个分组值[A....Z],获得该分组的第一项的position
     *
     * @param sectionIndex
     * @return
     */
    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getFirstLetter().charAt(0) == sectionIndex) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int position) {
        return userList.get(position).getFirstLetter().charAt(0);
    }


    public class ViewHolder {
        TextView username, showLetter;

    }
}
