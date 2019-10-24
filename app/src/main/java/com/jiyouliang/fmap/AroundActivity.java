package com.jiyouliang.fmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @Description:
 * @Author: 高烁
 * @CreateDate: 2019-08-26 16:20
 * @Email: gaoshuo521@foxmail.com
 */
public class AroundActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBackBtn;
    private RelativeLayout mParkBtn;
    private RelativeLayout mPetrolStationBtn;
    private RelativeLayout mDiningBtn;
    private RelativeLayout mAtmBtn;
    private RelativeLayout mSupermarketBtn;
    private RelativeLayout mCarFixBtn;
    private RelativeLayout mHospitalBtn;
    private RelativeLayout mHotelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.around_layout);
        initView();


    }

    private void initView() {
        mBackBtn = findViewById(R.id.back_btn);
        mBackBtn.setOnClickListener(this);
        mParkBtn = findViewById(R.id.park_btn);
        mParkBtn.setOnClickListener(this);
        mPetrolStationBtn = findViewById(R.id.petrol_station_btn);
        mPetrolStationBtn.setOnClickListener(this);
        mDiningBtn = findViewById(R.id.dining_btn);
        mDiningBtn.setOnClickListener(this);
        mAtmBtn = findViewById(R.id.atm_btn);
        mAtmBtn.setOnClickListener(this);
        mSupermarketBtn = findViewById(R.id.supermarket_btn);
        mSupermarketBtn.setOnClickListener(this);
        mCarFixBtn = findViewById(R.id.car_fix_btn);
        mCarFixBtn.setOnClickListener(this);
        mHospitalBtn = findViewById(R.id.hospital_btn);
        mHospitalBtn.setOnClickListener(this);
        mHotelBtn = findViewById(R.id.hotel_btn);
        mHotelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.park_btn:
                searchPio(getResources().getString(R.string.car_park));
                break;
            case R.id.petrol_station_btn:
                searchPio(getString(R.string.petrol_station));
                break;
            case R.id.dining_btn:
                searchPio(getString(R.string.dinner));
                break;
            case R.id.atm_btn:
                searchPio(getString(R.string.atm));
                break;
            case R.id.supermarket_btn:
                searchPio(getString(R.string.super_market));
                break;
            case R.id.car_fix_btn:
                searchPio(getString(R.string.car_fix));
                break;
            case R.id.hospital_btn:
                searchPio(getString(R.string.hospital));
                break;
            case R.id.hotel_btn:
                searchPio(getString(R.string.hotel));
                break;
            default:
                break;
        }
    }

    /*
    * 跳转回首页，并且搜索选中的poi
    * */
    private void searchPio(String poi){
        Intent intent = new Intent();
        //把返回数据存入Intent
        intent.putExtra(Constant.AroundMsg.KEY_POI, poi);
        setResult(RESULT_OK, intent);
        //关闭Activity
        finish();
    }
}
