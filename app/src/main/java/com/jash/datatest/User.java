package com.jash.datatest;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class User extends BaseObservable {
    private Drawable icon;
    @Bindable
    private String name;
    private static final String TAG = User.class.getSimpleName();
    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    public void clickIcon() {
        setName("clickIcon");
        Log.d(TAG, "clickIcon: " + getName());
    }
    public void clickName(TextView tv) {
        tv.setText("click");
        Toast.makeText(tv.getContext(), "name:" + name, Toast.LENGTH_SHORT).show();
    }

    public boolean longClickName(Context context) {
        Toast.makeText(context, "long click", Toast.LENGTH_SHORT).show();
        return true;
    }
}
