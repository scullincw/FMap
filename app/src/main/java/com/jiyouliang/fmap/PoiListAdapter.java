package com.jiyouliang.fmap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.services.core.PoiItem;

import java.util.ArrayList;
import java.util.List;



public class PoiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    List<PoiItem> poiItems;
    List<AdressModel> adressList = new ArrayList<>();
    List<AdressModel> adressFavoriteList = new ArrayList<>();

    public PoiListAdapter(Context context, List<PoiItem> poiItems) {
        this.mContext = context;
        this.poiItems = poiItems;
        for (int i = 0; i < poiItems.size(); i++) {
            PoiItem temp = poiItems.get(i);
            adressList.add(new AdressModel(temp));
        }
//        adressFavoriteList = DBUtil.getAdress(mContext, 0);
//        if (adressFavoriteList != null && adressFavoriteList.size() > 0) {
//            for (int i = 0; i < adressFavoriteList.size(); i++) {
//                AdressModel temp = adressFavoriteList.get(i);
//                for(int j = 0;j<adressList.size();j++){
//                    if(temp.getLatitude() == adressList.get(j).getLatitude()&&
//                            temp.getLongitude() == adressList.get(j).getLongitude()){
//                        adressList.get(j).setFavorite(true);
//                        adressList.get(j).setId(temp.getId());
//                    }
//                }
//            }
//
//        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poilist, parent, false);
        return new PoiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final PoiViewHolder mPoiViewHolder = (PoiViewHolder) holder;
        final AdressModel temp = adressList.get(position);
        mPoiViewHolder.tvIndex.setText(String.valueOf(position + 1));
        mPoiViewHolder.tvTitle.setText(temp.getTitle());
        mPoiViewHolder.tvAdress.setText(temp.getAdress());
        mPoiViewHolder.tvDuration.setText(String.valueOf(temp.getDistance()));
//
//        if (temp.isFavorite()) {
//            mPoiViewHolder.ivCollected.setImageResource(R.drawable.ic_navi_collected);
//        } else {
//            mPoiViewHolder.ivCollected.setImageResource(R.drawable.ic_navi_uncollected);
//        }
//        mPoiViewHolder.ivCollected.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!temp.isFavorite()) {
//                    DBUtil.addAdress(mContext, temp);
//                    temp.setFavorite(true);
//                    mPoiViewHolder.ivCollected.setImageResource(R.drawable.ic_navi_collected);
//                } else {
//                    DBUtil.delAdresses(mContext, temp);
//                    temp.setFavorite(false);
//                    mPoiViewHolder.ivCollected.setImageResource(R.drawable.ic_navi_uncollected);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return poiItems.size();
    }

    /**
     * Created by Android Studio.
     * User: chenfengnian
     * Date: 2019/8/1
     * Time: 14:17
     */
    class PoiViewHolder extends RecyclerView.ViewHolder {
        TextView tvIndex;
        TextView tvTitle;
        TextView tvAdress;
        TextView tvDuration;
        ImageView ivCollected;

        PoiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIndex = itemView.findViewById(R.id.tvIndex);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAdress = itemView.findViewById(R.id.tvAdress);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            ivCollected = itemView.findViewById(R.id.ivCollected);
        }
    }

}
