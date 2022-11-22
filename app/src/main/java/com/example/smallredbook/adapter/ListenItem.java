package com.example.smallredbook.adapter;

public class ListenItem {
    private String text_content;
    private int imageFilterViewId;
    private int imageViewId;
    public ListenItem(String text_content, int imageFilterViewId){
        this.text_content = text_content;
        this.imageFilterViewId = imageFilterViewId;
    }

    public String getText_content() {
        return text_content;
    }

    public int getImageFilterViewId() {
        return imageFilterViewId;
    }

    public int getImageViewId() {
        return imageViewId;
    }
}
