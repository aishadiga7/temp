package com.example.task.data.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagePageMap {
    @JsonProperty("cse_thumbnail")
    private ArrayList<ImageThumbNail> thumbNails;
    @JsonProperty("metatags")
    private ArrayList<ImageMetatags> metatags;

    public ArrayList<ImageThumbNail> getThumbNails() {
        return thumbNails;
    }

    public void setThumbNails(ArrayList<ImageThumbNail> thumbNails) {
        this.thumbNails = thumbNails;
    }

    public ArrayList<ImageMetatags> getMetatags() {
        return metatags;
    }

    public void setMetatags(ArrayList<ImageMetatags> metatags) {
        this.metatags = metatags;
    }
}
