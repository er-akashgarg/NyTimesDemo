package com.example.akashgarg.nytimessample.models;

import com.google.gson.annotations.SerializedName;

public class ResultsItem {

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    private long id;

    @SerializedName("byline")
    private String byline;

    @SerializedName("published_date")
    private String publishedDate;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }

    public String getByline() {
        return byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}