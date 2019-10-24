package com.jiyouliang.fmap;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.amap.api.maps.AMap;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

import java.util.List;

public class PoiManager implements PoiSearch.OnPoiSearchListener {

    private static final int ROUND_BROUND = 10000;
    private Context mContext;
    private AMap aMap;
    PoiSearch poiSearch;
    PoiSearch.Query query;

    private FrameLayout flRoot;
    private LinearLayout llSearch;
    private PoiSearchedView.PoiListener mPoiListener;
    private PoiSearchedView mPoiSearchedView;

    public PoiManager(Context mContext, AMap aMap, FrameLayout flRoot , LinearLayout llSearch) {
        this.mContext = mContext;
        this.aMap = aMap;
        this.flRoot = flRoot;
        this.llSearch = llSearch;
        mPoiListener = new PoiSearchedView.PoiListener() {
            @Override
            public void removeView() {
                removeAllView();
            }
        };

    }


    /*
     * 搜索poi
     * */
    public void queryPoi(String poi, String city, LatLonPoint currentLatlng) {

        query = new PoiSearch.Query(poi, "", city);
        //keyWord表示搜索字符串，
        //第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
        //cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);//设置查询页码

        poiSearch = new PoiSearch(mContext, query);
        poiSearch.setBound(new PoiSearch.SearchBound(currentLatlng, ROUND_BROUND));
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    /*
     * 添加view
     * */
    private void addView(List<PoiItem> poiItems) {
        llSearch.setVisibility(View.GONE);
        mPoiSearchedView = new PoiSearchedView(mContext,mPoiListener ,poiItems);
        flRoot.addView(mPoiSearchedView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

    }

    private void removeAllView(){
        llSearch.setVisibility(View.VISIBLE);
        aMap.clear();
        flRoot.removeView(mPoiSearchedView);
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {


        if (i == AMapException.CODE_AMAP_SUCCESS) {
            if (poiResult != null && poiResult.getQuery() != null) {
                if (poiResult.getQuery().equals(query)) {// 是否是同一条
                    // 取得搜索到的poiitems有多少页
                    List<PoiItem> poiItems = poiResult.getPois();// 取得第一页的poiitem数据，页数从数字0开始
                    List<SuggestionCity> suggestionCities = poiResult
                            .getSearchSuggestionCitys();// 当搜索不到poiitem数据时，会返回含有搜索关键字的城市信息

                    if (poiItems != null && poiItems.size() > 0) {
                        aMap.clear();// 清理之前的图标
                        PoiOverlay poiOverlay = new PoiOverlay(mContext, aMap, poiItems);
                        poiOverlay.removeFromMap();
                        poiOverlay.addToMap();
                        poiOverlay.zoomToSpan();
                        addView(poiItems);
                    }
                }
            }
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }
}
