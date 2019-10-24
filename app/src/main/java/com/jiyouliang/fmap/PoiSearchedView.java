package com.jiyouliang.fmap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.amap.api.services.core.PoiItem;

import java.util.List;

public class PoiSearchedView extends FrameLayout {

    private Context mContext;

    private ImageView ivBack;

    private RecyclerView mRecyclerView;
    private PoiListAdapter mPoiListAdapter;

    private PoiListener mPoiListener;

    List<PoiItem> poiItems;


    public PoiSearchedView(@NonNull Context context, PoiListener mPoiListener , List<PoiItem> poiItems) {
        super(context);
        this.mContext = context;
        this.mPoiListener = mPoiListener;
        this.poiItems = poiItems;
        initView();
    }

    public PoiSearchedView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PoiSearchedView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){
        LayoutInflater.from(mContext).inflate(R.layout.view_poisearched, this);
        ivBack = findViewById(R.id.ivBack);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPoiListener != null){
                    mPoiListener.removeView();
                }
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mPoiListAdapter = new PoiListAdapter(mContext,poiItems);
        mRecyclerView.setAdapter(mPoiListAdapter);

    }

   /*
   *添加回调
   * */
    public interface PoiListener {
        void removeView();
    }


}
