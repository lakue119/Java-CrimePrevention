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

public class jeonbukactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;


    private String stringcctv="";
    private String stringlamp="";

    private String capital = "전라북도";


    private MainActivity mainActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeonbukactivity);

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
    public void onClickGunsan(View v)
    {
        SandData("35.96762","126.73687",R.raw.jeollabukgunsancctv,R.raw.jeollabukgunsanlamp,"군산");
    }
    public void onClickIksan(View v)
    {
        SandData("35.94834","126.95755",R.raw.jeollabukiksancctv,R.raw.jeonbukiksanlamp,"익산");
    }
    public void onClickWanju(View v)
    {
        SandData("35.90479","127.16217",R.raw.jeollabukwanjucctv,R.raw.jeollabukwanjulamp,"완주");
    }
    public void onClickMuju(View v)
    {
        SandData("36.00698","127.66054",R.raw.jeollabukmujucctv,R.raw.jeollabukmujulamp,"무주");
    }
    public void onClickJinan(View v)
    {
        SandData("35.79177","127.42489",R.raw.jeollabukjinancctv, R.raw.nulll,"진안");
    }
    public void onClickJeonju(View v)
    {
        SandData("35.82410","127.14804",R.raw.jeollabukjeonjucctv,R.raw.jeollabukjeonjulamp,"전주");
    }
    public void onClickGimje(View v)
    {
        SandData("35.80358","126.88037",R.raw.nulll,R.raw.jeonbukgimjelamp,"김제");
    }
    public void onClickJangsu(View v)
    {
        SandData("35.41702","127.39303",R.raw.jeollabukjangsucctv,R.raw.nulll,"장수");
    }
    public void onClickBuan(View v)
    {
        SandData("35.73070","126.73425",R.raw.jeollabukbuancctv, R.raw.jeollabukbuanlamp,"부안");
    }
    public void onClickJeongeup(View v)
    {
        SandData("35.56988","126.85602",R.raw.jeollabukjeongeupcctv,R.raw.jeollabukjeongeuplamp,"정읍");
    }
    public void onClickImsil(View v)
    {
        SandData("35.61785","127.28911",R.raw.jeollabukimsilcctv,R.raw.jeollabukimsillamp,"임실");
    }
    public void onClickGochang(View v)
    {
        SandData("35.43579","126.70207",R.raw.jeollabukgochangcctv, R.raw.nulll,"고창");
    }
    public void onClickSunchang(View v)
    {
        SandData("35.37495","127.13694",R.raw.jeollabuksunchangcctv,R.raw.jeollabuksunchanglamp,"순창");
    }
    public void onClickNamwon(View v)
    {
        SandData("35.41643","127.39047",R.raw.jeollabuknamwoncctv,R.raw.jeollabuknamwonlamp,"남원");
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