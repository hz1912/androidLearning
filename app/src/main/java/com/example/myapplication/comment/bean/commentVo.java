package com.example.myapplication.comment.bean;

import java.util.List;

public class commentVo {
    private int code;
    private String message;
    private Data result;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(Data data) {
        this.result = data;
    }

    public Data getData() {
        return result;
    }

    public class Data {
        List<CommonCommentVoResponseVo> commentVoResponseVoList;

        public void setList(List<CommonCommentVoResponseVo> list) {
            this.commentVoResponseVoList = list;
        }

        public List<CommonCommentVoResponseVo> getList() {
            return commentVoResponseVoList;
        }

    }
}
