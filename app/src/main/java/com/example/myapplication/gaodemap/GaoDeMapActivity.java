package com.example.myapplication.gaodemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolylineOptions;
import com.example.myapplication.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GaoDeMapActivity extends AppCompatActivity implements AMapLocationListener {

    private MapView aMapView;

    private AMap aMap;

    //控件是指浮在地图图面上的一系列用于操作地图的组件，例如缩放按钮、指南针、定位按钮、比例尺等。
    private UiSettings mUiSettings;//定义一个UiSettings对象


    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;


    public AMapLocationClientOption mLocationOption = null;


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_de_map);
        aMapView = findViewById(R.id.gaodemap);
        aMap = aMapView.getMap();
        mUiSettings = aMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
        aMapView.onCreate(savedInstanceState);
        aMap.setMapType(AMap.MAP_TYPE_NIGHT);
        aMap.setTrafficEnabled(true);
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //启动定位
        mLocationClient.startLocation();

    }


    @Override
    protected void onResume() {
        super.onResume();
        aMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        aMapView.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        aMapView.onDestroy();
    }

    /**
     * 绘制自定义 Marker
     */
    public void customerMarker() {
        MarkerOptions markerOption = new MarkerOptions();
        LatLng latLng = new LatLng(39.906901, 116.397972);
        markerOption.position(latLng);
        markerOption.title("西安市").snippet("西安市：34.341568, 108.940174");
        markerOption.draggable(true);//设置Marker可拖动
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bg_btn2)));
        markerOption.setFlat(true);

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
//可在其中解析amapLocation获取相应内容。
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                aMapLocation.getLatitude();//获取纬度
                aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                Log.e(TAG,"country"+aMapLocation.getCountry());
            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo());
            }
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
