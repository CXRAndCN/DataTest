package com.jash.datatest;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("content")
    private String content;
    @SerializedName("pic_url")
    private String pic;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
