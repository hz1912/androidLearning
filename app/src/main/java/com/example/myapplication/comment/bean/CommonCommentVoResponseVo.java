package com.example.myapplication.comment.bean;


import java.util.List;


public class CommonCommentVoResponseVo {

    private Integer commentId = 0;

    private Integer topicId = 0;

    private Integer topicType = 0;

    private Integer topicKey = 0;

    private String content = "";

    private Integer toUid = 0;

    private String toUserNickName = "";

    private String toUserHeadImg = "";

    private String toUserNo = "";

    private Integer fromUid = 0;

    private String fromUserNickName = "";

    private String fromUserHeadImg = "";

    private String fromUserNo = "";

    private Integer isTop = 0;

    private Integer praiseNum = 0;

    private Integer replyNum = 0;

    private Integer isReply = 0;

    private Integer status = 0;

    private String score = "0";

    private Integer score1;

    private Integer score2;

    private Integer score3;

    private String reward = "0";

    private Integer sort = 0;

    private long dateTime;

    private Integer totalCommentCount = 0;

    private long durTime=0;

    private  String durTimeformate;

    private  Integer isPrise;

    private  String contentRes;
    private  int contentType;

    List<CommonCommentReplyResponseVo> commentReplys;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicType() {
        return topicType;
    }

    public void setTopicType(Integer topicType) {
        this.topicType = topicType;
    }

    public Integer getTopicKey() {
        return topicKey;
    }

    public void setTopicKey(Integer topicKey) {
        this.topicKey = topicKey;
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

    public String getToUserNo() {
        return toUserNo;
    }

    public void setToUserNo(String toUserNo) {
        this.toUserNo = toUserNo;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
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

    public String getFromUserNo() {
        return fromUserNo;
    }

    public void setFromUserNo(String fromUserNo) {
        this.fromUserNo = fromUserNo;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getIsReply() {
        return isReply;
    }

    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getScore3() {
        return score3;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getTotalCommentCount() {
        return totalCommentCount;
    }

    public void setTotalCommentCount(Integer totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    public long getDurTime() {
        return durTime;
    }

    public void setDurTime(long durTime) {
        this.durTime = durTime;
    }

    public String getDurTimeformate() {
        return durTimeformate;
    }

    public void setDurTimeformate(String durTimeformate) {
        this.durTimeformate = durTimeformate;
    }

    public Integer getIsPrise() {
        return isPrise;
    }

    public void setIsPrise(Integer isPrise) {
        this.isPrise = isPrise;
    }

    public String getContentRes() {
        return contentRes;
    }

    public void setContentRes(String contentRes) {
        this.contentRes = contentRes;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public List<CommonCommentReplyResponseVo> getCommentReplys() {
        return commentReplys;
    }

    public void setCommentReplys(List<CommonCommentReplyResponseVo> commentReplys) {
        this.commentReplys = commentReplys;
    }
}
