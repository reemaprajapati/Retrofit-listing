package com.example.otimus.retrolisting.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Otimus on 10/31/2016.
 */
public class PostItem {
    @SerializedName("userID")
    String userId;

    @SerializedName("id")
    Integer id;

    @SerializedName("title")
    String title;

    @SerializedName("body")
    String body;

    public PostItem(String userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
