package com.jiyouliang.fmap;

import com.amap.api.services.core.PoiItem;

public class AdressModel {

    /*
     * 名称
     * */
    private String title;

    /*
     * 详细地址
     * */
    private String adress;

    /*
     * 经纬度
     * */
    private double latitude;
    private double longitude;

    /*
     *地址id
     * */
    private String id;

    /*
     * 类型
     * */
    private int type;

    /*
    *提示区域编码
    * *//*
    private String adcode;

    *//*
    * 提示区域
    * *//*
    private String district;*/


    /*
     * 是否被收藏了
     * */
    private boolean isFavorite;



    private int distance;


    public AdressModel(PoiItem poiItem) {

        this.adress = poiItem.getSnippet();
        this.title = poiItem.getTitle();
        this.latitude = poiItem.getLatLonPoint().getLatitude();
        this.longitude = poiItem.getLatLonPoint().getLongitude();
        this.distance = poiItem.getDistance();
    }

    public AdressModel() {

    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
