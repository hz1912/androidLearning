package com.example.myapplication.comment.bean;



public class CommonCommentReplyResponseVo {

    private Integer id = 0;

    private Integer commentId = 0;

    private Integer replyType = 0;

    private Integer replyId = 0;

    private String content = "";

    private Integer toUid = 0;

    private String toUserNickName = "";

    private String toUserHeadImg = "";

    private Integer fromUid = 0;

    private Integer contentType;

    private String contentRes;

    private String fromUserNickName = "";

    private String fromUserHeadImg = "";

    private Integer isAuthor = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public String getToUserNickName() {
        return toUserNickName;
    }

    public void setToUserNickName(String toUserNickName) {
        this.toUserNickName = toUserNickName;
    }

    public String getToUserHeadImg() {
        return toUserHeadImg;
    }

    public void setToUserHeadImg(String toUserHeadImg) {
        this.toUserHeadImg = toUserHeadImg;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContentRes() {
        return contentRes;
    }

    public void setContentRes(String contentRes) {
        this.contentRes = contentRes;
    }

    public String getFromUserNickName() {
        return fromUserNickName;
    }

    public void setFromUserNickName(String fromUserNickName) {
        this.fromUserNickName = fromUserNickName;
    }

    public String getFromUserHeadImg() {
        return fromUserHeadImg;
    }

    public void setFromUserHeadImg(String fromUserHeadImg) {
        this.fromUserHeadImg = fromUserHeadImg;
    }

    public Integer getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Integer isAuthor) {
        this.isAuthor = isAuthor;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    private long dateTime;

}
