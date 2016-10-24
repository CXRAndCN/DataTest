package com.jash.datatest;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends BaseAdapter{
    private List<?> list;
    private int layoutId;
    private int variableId;
    public static CommentAdapter getInstance(List<?> list, int layoutId) {
        CommentAdapter ca = new CommentAdapter();
        if (list == null) {
            list = new ArrayList<>();
        }
        ca.list = list;
        ca.layoutId = layoutId;

        ca.variableId = BR.item;
        return ca;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false).getRoot();
        }
        ViewDataBinding binding = DataBindingUtil.getBinding(convertView);
        binding.setVariable(variableId, list.get(position));
        return convertView;
    }
}
