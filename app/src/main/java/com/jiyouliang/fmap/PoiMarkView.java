package com.jiyouliang.fmap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PoiMarkView extends FrameLayout {

    private Context mContext;
    private TextView tvIndex;
    private int index;

    public PoiMarkView(@NonNull Context context , int index) {
        super(context);
        this.mContext = context;
        this.index = index;
        initView();
    }

    private void initView(){

        LayoutInflater.from(mContext).inflate(R.layout.poi_mark, this);
        tvIndex = findViewById(R.id.tvIndex);
        tvIndex.setText(String.valueOf(index));
    }
}
