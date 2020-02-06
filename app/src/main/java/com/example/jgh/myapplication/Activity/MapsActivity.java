package com.example.jgh.myapplication.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jgh.myapplication.Model.ArraylocalData;
import com.example.jgh.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{


    private GoogleMap mMap;

    private String valuex;
    private String valuey;
    private String stringcctv = "";
    private String stringlamp = "";
    private String stringpopulation = "";
    private String stringcrime = "";
    private String[] mX = {};
    private String[] mY = {};
    private int getindex = 0;
    private double[] cctvdoublex = {};
    private double[] cctvdoubley = {};
    private int cctvsize = 0;
    private double[] lampx = {};
    private double[] lampy = {};
    private int lampsize = 0;
    private Button btn_plus;
    private Button btn_cctv;
    private Button btn_lamp;
    private Button btn_bbb;
    private Button btn_ccc;
    private Button btn_ddd;
    private String capital;
    private String local;

    public static ArrayList<ArraylocalData> arraylocalData;
    ArrayList<Double> changwonx;
    ArrayList<Double> changwony ;

    MarkerOptions cctvmarkeroptions;
    MarkerOptions lampmarkeroptions;

    private MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        arraylocalData = new ArrayList<ArraylocalData>();
        changwonx = new ArrayList<Double>();
        changwony = new ArrayList<Double>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent(); //이 액티비티를 부른 인텐트를 받는다.
        valuex = intent.getStringExtra("X"); //"jizard"문자 받아옴
        valuey = intent.getStringExtra("Y"); //119 받아옴
        stringcctv = intent.getStringExtra("cctvXY");
        stringlamp = intent.getStringExtra("lampXY");
        stringpopulation = intent.getStringExtra("localpopulation");
        stringcrime = intent.getStringExtra("localcrime");
        capital = intent.getStringExtra("Capital");
        local = intent.getStringExtra("Local");

        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_cctv = (Button) findViewById(R.id.btn_cctv);
        btn_lamp = (Button) findViewById(R.id.btn_lamp);
        btn_bbb = (Button) findViewById(R.id.btn_bbb);
        btn_ccc = (Button) findViewById(R.id.btn_ccc);
        btn_ddd = (Button) findViewById(R.id.btn_ddd);

        arraylocalData.addAll(mainActivity.arraylocalData);

        GetIndex();


    }

   /* public void onMapClick(LatLng point){
// 현재 위도와 경도에서 화면 포인트를 알려준다
        Point screenPt = mMap.getProjection().
                toScreenLocation(point);

        // 현재 화면에 찍힌 포인트로 부터 위도와 경도를 알려준다.
        LatLng latLng = mMap.getProjection().
                fromScreenLocation(screenPt);

        LatLng cctvlatlng = new LatLng(point.latitude, point.longitude);
        mMap.addMarker(lampmarkeroptions.position(cctvlatlng)
                .title(point.latitude + "," + point.longitude)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lamp)));

        Log.d("맵좌표","좌표: 위도(" + String.valueOf(point.latitude) + "), 경도(" + String.valueOf(point.longitude) + ")");
                Log.d("화면좌표","화면좌표: X(" + String.valueOf(screenPt.x) + "), Y(" + String.valueOf(screenPt.y) + ")");
    }

    public void addmark(boolean iscctv, LatLng point){
        if(iscctv==true){
            LatLng cctvlatlng = new LatLng(point.latitude, point.longitude);
            mMap.addMarker(lampmarkeroptions.position(cctvlatlng)
                    .title(point.latitude + "," + point.longitude)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.cctv3)));
        } else if(iscctv==false){
            LatLng lamplatlng = new LatLng(point.latitude, point.longitude);
            mMap.addMarker(lampmarkeroptions.position(lamplatlng)
                    .title(point.latitude + "," + point.longitude)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.lamp)));
        }

    }*/

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        cctvmarkeroptions = new MarkerOptions();
        lampmarkeroptions = new MarkerOptions();


        float ValueX = Float.parseFloat(valuex);
        float ValueY = Float.parseFloat(valuey);

        StringChange(stringcctv, true);
        StringChange(stringlamp, false);
        ShowText();
       // SavaData();

        for (int i = 0; i < cctvsize; ++i) {
            LatLng cctvlatlng = new LatLng(cctvdoublex[i], cctvdoubley[i]);
            mMap.addMarker(cctvmarkeroptions.position(cctvlatlng)
                    .title(cctvdoublex[i] + "," + cctvdoubley[i])
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.cctv3)));

        }
        if(local.equals("창원")){
            CsvData();
            for (int i = 0; i < changwonx.size(); ++i) {
                LatLng lamplatlng = new LatLng(changwonx.get(i), changwony.get(i));
                mMap.addMarker(lampmarkeroptions.position(lamplatlng)
                        .title(changwonx.get(i) + "," + changwony.get(i))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.lamp)));

            }
        } else {
            for (int i = 0; i < lampsize; ++i) {
                LatLng lamplatlng = new LatLng(lampx[i], lampy[i]);
                mMap.addMarker(lampmarkeroptions.position(lamplatlng)
                        .title(lampx[i] + "," + lampy[i])
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.lamp)));

            }
        }
        mMap.setMinZoomPreference(15.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(ValueX, ValueY)));
        //SandData();
       // mMap.setOnMapClickListener(this);
    }

    private void StringChange(String mark, boolean iscctv) {

        String tempX = "";
        String tempY = "";

        double[] changex;
        double[] changey;

        String tempStr = mark.substring(1, mark.length() - 1);
        String tempStrr = tempStr.replaceAll(" ", "");
        String[] tempArr = tempStrr.split(",");


        for (int i = 0; i < tempArr.length; ++i) {
            if (i % 2 == 0) {
                if (i == tempArr.length - 1 || i == tempArr.length - 2) {
                    tempX = tempX.concat(tempArr[i]);
                } else {
                    tempX = tempX.concat(tempArr[i] + ",");
                }
            }
            if (i % 2 != 0) {
                if (i == tempArr.length - 1 || i == tempArr.length - 2) {
                    tempY = tempY.concat(tempArr[i]);
                } else {
                    tempY = tempY.concat(tempArr[i] + ",");
                }
            }
        }
        mX = tempX.split(",");
        mY = tempY.split(",");

        changex = new double[tempArr.length / 2];
        changey = new double[tempArr.length / 2];

        for (int i = 0; i < changex.length; ++i) {
            changex[i] = Double.parseDouble(mX[i]);
            changey[i] = Double.parseDouble(mY[i]);
        }

        if (iscctv == true) {
            cctvsize = mY.length;
            cctvdoublex = changex;
            cctvdoubley = changey;
        } else if (iscctv == false) {
            lampsize = mY.length;
            lampx = changex;
            lampy = changey;
        } else {
        }
    }

    public void onClickPlus(View v) {
        if (btn_cctv.getVisibility() == v.GONE && btn_lamp.getVisibility() == v.GONE && btn_bbb.getVisibility() == v.GONE) {
            btn_cctv.setVisibility(v.VISIBLE);
            btn_lamp.setVisibility(v.VISIBLE);
            btn_bbb.setVisibility(v.VISIBLE);
        } else {
            btn_cctv.setVisibility(v.GONE);
            btn_lamp.setVisibility(v.GONE);
            btn_bbb.setVisibility(v.GONE);
        }
    }

    public void onClickcctv(View v) {
        mMap.clear();
        MarkerOptions cctvmarkeroptions = new MarkerOptions();
        float ValueX = Float.parseFloat(valuex);
        float ValueY = Float.parseFloat(valuey);
        StringChange(stringcctv, true);
        for (int i = 0; i < cctvsize; ++i) {
            LatLng cctvlatlng = new LatLng(cctvdoublex[i], cctvdoubley[i]);
            mMap.addMarker(cctvmarkeroptions.position(cctvlatlng)
                    .title(cctvdoublex[i] + "," + cctvdoubley[i])
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.cctv3)));
            mMap.setMinZoomPreference(10.0f);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(ValueX, ValueY)));
        }
    }

    public void onClicklamp(View v) {
        mMap.clear();
        MarkerOptions lampmarkeroptions = new MarkerOptions();
        float ValueX = Float.parseFloat(valuex);
        float ValueY = Float.parseFloat(valuey);
        StringChange(stringlamp, false);
        for (int i = 0; i < lampsize; ++i) {
            LatLng lamplatlng = new LatLng(lampx[i], lampy[i]);
            mMap.addMarker(lampmarkeroptions.position(lamplatlng)
                    .title(lampx[i] + "," + lampy[i])
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.lamp)));

        }
        mMap.setMinZoomPreference(15.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(ValueX, ValueY)));
    }

    int idx = 0;
    public void onClickResult(View v) {
        for(int i=0;i<mainActivity.solution_arraylocalData.size();++i){
            if(mainActivity.solution_arraylocalData.get(i).getCapitalData().equals(capital)&&
                    mainActivity.solution_arraylocalData.get(i).getLocalData().equals(local)) {
                idx = i;
                break;

            } else{}
        }

        if(mainActivity.solution_arraylocalData.get(idx).getCapitalData().equals(capital)&&
                mainActivity.solution_arraylocalData.get(idx).getLocalData().equals(local)){
            SandData();

        }else {Toast.makeText(getApplicationContext(),"비교하기에는 데이터가 부족합니다.",Toast.LENGTH_LONG).show(); }
    }

    public void ShowText() {
        TextView txt_capital = (TextView) findViewById(R.id.txt_Capital);
        txt_capital.setGravity(Gravity.CENTER);
        TextView txt_local = (TextView) findViewById(R.id.txt_Local);
        txt_local.setGravity(Gravity.CENTER);

        if(capital.equals("제주특별자치도"))
        {
            txt_capital.setText(Html.fromHtml("<small>"+capital+"<small>"));
        }else {txt_capital.setText(capital);}
        txt_local.setText(local);

        TextView chungbukcctvcount = (TextView) findViewById(R.id.txt_cctvcount);
        if (cctvsize == 1) {
            chungbukcctvcount.setText("데이터없음");
        } else {
            chungbukcctvcount.setText(mainActivity.arraylocalData.get(getindex).getCctvData()+"대");
        }


        TextView chungbuklampcount = (TextView) findViewById(R.id.txt_lampcount);
        if (lampsize == 1) {
            if(local.equals("창원")){
                chungbuklampcount.setText(mainActivity.arraylocalData.get(getindex).getLampData()+"대");
            } else{
            chungbuklampcount.setText("데이터없음");
            }
        } else {
            chungbuklampcount.setText(mainActivity.arraylocalData.get(getindex).getLampData()+"대");
        }


        TextView Populationcount = (TextView) findViewById(R.id.txt_Population);
        Populationcount.setText(mainActivity.arraylocalData.get(getindex).getPopulationData()+"명");

        TextView Crimecount = (TextView) findViewById(R.id.txt_Crime);
        Crimecount.setText(mainActivity.arraylocalData.get(getindex).getCrimeData()+"건");
    }

    public void SandData() {
        Intent intent = new Intent(this, DataAnalysisGraph.class);

        intent.putExtra("MapCapital",capital);
        intent.putExtra("MapLocal",local);
        startActivity(intent);
    }

    public void GetIndex(){
        for(int i=0;i<mainActivity.arraylocalData.size();i++){
            if(mainActivity.arraylocalData.get(i).getCapitalData().equals(capital)&&
                    mainActivity.arraylocalData.get(i).getLocalData().equals(local)){
                getindex = i;
            }

        }
    }
    public void CsvData(){
        InputStream is = getResources().openRawResource(R.raw.gyeongnamchangwonlamp);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line ="";
        try{
            reader.readLine();
            while( (line = reader.readLine()) != null){

                String[] tokens = line.split(",");
                changwonx.add(Double.parseDouble(tokens[0]));
                changwony.add(Double.parseDouble(tokens[1]));
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}