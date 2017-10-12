package com.system.bean;

public class Comment {
    private String username;
    private String time;
    private String comment;
    private String up;
    private String count_id;
    public String getCount_id() {
        return count_id;
    }
    public void setCount_id(String count_id) {
        this.count_id = count_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getUp() {
        return up;
    }
    public void setUp(String up) {
        this.up = up;
    }

}
