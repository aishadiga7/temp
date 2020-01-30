package com.example.task.data.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponseItems {
    @JsonProperty("pagemap")
    private ImagePageMap imagePageMap;

    public ImagePageMap getImagePageMap() {
        return imagePageMap;
    }

    public void setImagePageMap(ImagePageMap imagePageMap) {
        this.imagePageMap = imagePageMap;
    }
}
