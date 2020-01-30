package com.example.task.data.remote.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponse {
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("items")
    private ArrayList<ImageResponseItems> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ArrayList<ImageResponseItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<ImageResponseItems> items) {
        this.items = items;
    }
}
