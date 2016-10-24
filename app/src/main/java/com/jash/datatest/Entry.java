package com.jash.datatest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {
    @SerializedName("items")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
