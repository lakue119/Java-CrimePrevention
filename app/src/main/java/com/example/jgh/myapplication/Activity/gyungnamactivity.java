package com.example.jgh.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jgh.myapplication.Model.MarkData;
import com.example.jgh.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class gyungnamactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "경상남도";
    private MainActivity mainActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyungnamactivity);
        int idx = 0;
        for(int i=0;i<mainActivity.arraylocalData.size();i++){
            if(mainActivity.arraylocalData.get(i).getCapitalData().equals(capital)&&
                    mainActivity.arraylocalData.get(i).getLocalData().equals("전체")){
                idx = i;
            }
        }
        TextView cctvcount = (TextView)findViewById(R.id.txt_cctvcount);
        cctvcount.setText(mainActivity.arraylocalData.get(idx).getCctvData()+"대");

        TextView lampcount = (TextView)findViewById(R.id.txt_lampcount);
        lampcount.setText(mainActivity.arraylocalData.get(idx).getLampData()+"대");

        TextView Populationcount = (TextView)findViewById(R.id.txt_Population);
        Populationcount.setText(mainActivity.arraylocalData.get(idx).getPopulationData()+"명");

        TextView Crimecount = (TextView)findViewById(R.id.txt_Crime);
        Crimecount.setText(mainActivity.arraylocalData.get(idx).getCrimeData()+"건");
    }

    public void onClickGeochang(View v) {
        SandData("35.68668", "127.90954",R.raw.gyeongsangnamgeochangcctv,R.raw.nulll,"거창");
    }

    public void onClickHamyang(View v) {
        SandData("35.52069", "127.72545",R.raw.gyeongsangnamhamyangcctv,R.raw.gyeongnamhamyanglamp,"함양");
    }

    public void onClickHapcheon(View v) {
        SandData("35.56665", "128.16583",R.raw.gyeongsangnamhapcheoncctv,R.raw.nulll,"합천");
    }

    public void onClickChangnyeong(View v) {
        SandData("35.54462", "128.49232",R.raw.gyeongsangnamchangnyeongcctv,R.raw.nulll,"창녕");
    }

    public void onClickMiryang(View v) {
        SandData("35.50383", "128.74670",R.raw.gyeongsangnammiryangcctv,R.raw.gyeongnammiryanglamp,"밀양");
    }

    public void onClickYangsan(View v) {
        SandData("35.33497", "129.03694",R.raw.gyeongsangnamyangsancctv,R.raw.nulll,"양산");
    }

    public void onClickGimhae(View v) {
        SandData("35.22860", "128.88927",R.raw.gyeongsangnamgimhaecctv,R.raw.gyeongsangnamgimhaelamp,"김해");
    }

    public void onClickChangwon(View v) {
        SandData("35.22790", "128.68165",R.raw.gyeongsangnamchangwoncctv,R.raw.nulll,"창원");
    }

    public void onClickHaman(View v) {
        SandData("35.27256", "128.40649",R.raw.gyeongsangnamhamancctv,R.raw.gyeongnamhamanlamp,"함안");
    }

    public void onClickUiryeong(View v) {
        SandData("35.32224", "128.26170",R.raw.gyeongsangnamuiryeongcctv,R.raw.gyeongnamuiryeonglamp,"의령");
    }

    public void onClickSancheong(View v) {
        SandData("35.41556", "127.87347",R.raw.gyeongsangnamsancheongcctv,R.raw.gyeongnamsancheonglamp,"산청");
    }

    public void onClickJinju(View v) {
        SandData("35.18025", "128.10785",R.raw.gyeongsangnamjinjucctv,R.raw.gyeongnamjinjulamp,"진주");
    }

    public void onClickHadong(View v) {
        SandData("35.06731", "127.75132",R.raw.gyeongsangnamhadongcctv,R.raw.gyeongsangnamhadonglamp,"하동");
    }

    public void onClickSacheon(View v) {
        SandData("35.00359", "128.06475",R.raw.gyeongsangnamsacheoncctv,R.raw.gyeongsangnamsacheonlamp,"사천");
    }
    public void onClickGoseong(View v) {
        SandData("34.97274", "128.32231",R.raw.gyeongsangnamgoseongcctv,R.raw.gyeongnamgoseonglamp,"고성");
    }

    public void onClickTongyeong(View v) {
        SandData("34.85431", "128.43300",R.raw.gyeongsangnamtongyeongcctv,R.raw.gyeongnamtongyeonglamp,"통영");
    }

    public void onClickGeoje(View v) {
        SandData("34.88044   ", "128.62120",R.raw.gyeongsangnamgeojecctv,R.raw.gyeongnamgeojelamp,"거제");
    }
    public void onClickNamhae(View v) {
        SandData("34.83773", "127.89265",R.raw.gyeongsangnamnamhaecctv,R.raw.gyeongnamnamhaelamp,"남해");
    }


    public void SandData(String X,String Y,int cctv_file,int lamp_file,String local)
    {

        //SubActivity로 가는 인텐트를 생성
        markdata = new ArrayList<MarkData>();
        lampdata = new ArrayList<MarkData>();
        Intent intent = new Intent(this, MapsActivity.class);

        CsvData(markdata,cctv_file);
        CsvData(lampdata,lamp_file);

        stringcctv = markdata.toString();
        stringlamp = lampdata.toString();

        intent.putExtra("X",X);
        intent.putExtra("Y",Y);
        intent.putExtra("cctvXY",stringcctv);
        intent.putExtra("lampXY",stringlamp);
        intent.putExtra("Capital",capital);
        intent.putExtra("Local",local);
        startActivity(intent);
    }

    public void CsvData(ArrayList<MarkData> data, int file_name){


        InputStream is = getResources().openRawResource(file_name);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line ="";
        try{
            reader.readLine();
            while( (line = reader.readLine()) != null){

                String[] tokens = line.split(",");
                MarkData getdata = new MarkData();
                  getdata.setX(tokens[0]);
                getdata.setY(tokens[1]);
                data.add(getdata);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}