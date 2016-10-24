package com.jash.datatest;

import android.text.TextUtils;
import android.widget.ImageView;

import org.xutils.x;

public class BindingAdapter {
    @android.databinding.BindingAdapter("loadImage")
    public static void loadImage(ImageView view, String url) {
        if (!TextUtils.isEmpty(url)) {
            x.image().bind(view, url);
        }
    }
}
