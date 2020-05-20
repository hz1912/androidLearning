package com.example.myapplication.comment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;
import com.example.myapplication.comment.bean.CommonCommentReplyResponseVo;
import com.example.myapplication.comment.bean.CommonCommentVoResponseVo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CommentActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private CommentExpandAdapter adapter;
    private List<CommonCommentVoResponseVo> commentsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        sendPostRequest();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initView();
    }

    private void initView() {
        expandableListView = findViewById(R.id.detail_page_lv_comment);
        initExpandableListView(commentsList);
    }


    public String sendPostRequest() {
        String url = "http://test.api.langooo.com/comment/getCommentList";
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String jsonStr = "{\n" +
                "\t\"uid\":308,\n" +
                "\t\"topicId\":32,\n" +
                "\t\"topicType\":10\n" +
                "}";
        Request request = new Request.Builder().url(url).post(RequestBody.create(JSON, jsonStr)).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                String test = responseBody.string();
                commentsList = generateTestData(test);
            }
        });
        return null;

    }


    /**
     * 初始化评论和回复列表
     */
    private void initExpandableListView(final List<CommonCommentVoResponseVo> commentList) {
        expandableListView.setGroupIndicator(null);
        //默认展开所有回复
        adapter = new CommentExpandAdapter(CommentActivity.this, commentsList);
        expandableListView.setAdapter(adapter);
        for (int i = 0; i < commentList.size(); i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                boolean isExpanded = expandableListView.isGroupExpanded(groupPosition);
                Log.e("CommentActivity", "onGroupClick: 当前的评论id>>>" +isExpanded);
                return true;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                Log.e("CommentActivity", "onGroupClick: 当前的评论id>>>" + commentList.get(groupPosition).getCommentId());
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

    }

    /**
     * by moos on 2018/04/20
     * func:生成测试数据
     *
     * @return 评论数据
     */
    private List<CommonCommentVoResponseVo> generateTestData(String testJson) {
        JSONObject jsonObject = JSON.parseObject(testJson);
        JSONObject jsonObject1 = jsonObject.getJSONObject("result");
        JSONArray jsonArray = jsonObject1.getJSONArray("commentVoResponseVoList");
        List<CommonCommentVoResponseVo> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            List<CommonCommentReplyResponseVo> commentReplys = new ArrayList<>();
            CommonCommentVoResponseVo commonCommentVoResponseVo = new CommonCommentVoResponseVo();
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            commonCommentVoResponseVo.setCommentId(jsonObject2.getInteger("commentId"));
            commonCommentVoResponseVo.setTopicId(jsonObject2.getInteger("topicId"));
            commonCommentVoResponseVo.setTopicType(jsonObject2.getInteger("topicType"));
            commonCommentVoResponseVo.setContent(jsonObject2.getString("content"));
            commonCommentVoResponseVo.setToUid(jsonObject2.getInteger("toUid"));
            commonCommentVoResponseVo.setToUserNickName(jsonObject2.getString("toUserNickName"));
            commonCommentVoResponseVo.setToUserHeadImg(jsonObject2.getString("toUserHeadImg"));
            commonCommentVoResponseVo.setFromUid(jsonObject2.getInteger("fromUid"));
            commonCommentVoResponseVo.setFromUserNickName(jsonObject2.getString("fromUserNickName"));
            commonCommentVoResponseVo.setFromUserHeadImg(jsonObject2.getString("fromUserHeadImg"));
            JSONArray jsonArray2 = jsonObject2.getJSONArray("commentReplys");
            if (jsonArray2 != null) {
                for (int j = 0; j < jsonArray2.size(); j++) {
                    JSONObject jsonObject3 = jsonArray.getJSONObject(i);
                    CommonCommentReplyResponseVo commonCommentReplyResponseVo = new CommonCommentReplyResponseVo();
                    commonCommentReplyResponseVo.setCommentId(jsonObject3.getInteger("commentId"));
                    commonCommentReplyResponseVo.setReplyType(jsonObject3.getInteger("replyType"));
                    commonCommentReplyResponseVo.setReplyId(jsonObject3.getInteger("replyId"));
                    commonCommentReplyResponseVo.setContent(jsonObject3.getString("content"));
                    commonCommentReplyResponseVo.setToUid(jsonObject3.getInteger("toUid"));
                    commonCommentReplyResponseVo.setToUserNickName(jsonObject3.getString("toUserNickName"));
                    commonCommentReplyResponseVo.setToUserHeadImg(jsonObject3.getString("toUserHeadImg"));
                    commonCommentReplyResponseVo.setFromUid(jsonObject3.getInteger("fromUid"));
                    commonCommentReplyResponseVo.setFromUserNickName(jsonObject3.getString("fromUserNickName"));
                    commonCommentReplyResponseVo.setFromUserHeadImg(jsonObject3.getString("fromUserHeadImg"));
                    commentReplys.add(commonCommentReplyResponseVo);
            }

            }
            commonCommentVoResponseVo.setCommentReplys(commentReplys);
            list.add(commonCommentVoResponseVo);
        }
        return list;
    }
}
