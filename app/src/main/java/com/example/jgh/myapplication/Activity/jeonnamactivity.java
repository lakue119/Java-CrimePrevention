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

public class jeonnamactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";

    private String capital = "전라남도";

    private MainActivity mainActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeonnamactivity);

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
    public void onClickYeonggwang(View v) {
        SandData("35.27718", "126.51196",R.raw.jeollanamyeonggwangcctv,R.raw.nulll,"영광");
    }

    public void onClickGokseong(View v) {
        SandData("35.27941", "127.29273",R.raw.jeollanamgokseongcctv,R.raw.jeonnamnamgokseonglamp,"곡성");
    }

    public void onClickGurye(View v) {
        SandData("35.2252", "127.46275",R.raw.jeollanamguryecctv,R.raw.jeonnamnamguryelamp,"구례");
    }

    public void onClickGwangyang(View v) {
        SandData("34.94060", "127.69596",R.raw.jeollanamgwangyangcctv,R.raw.jeonnamnamgwangyanglamp,"광양");
    }

    public void onClickNaju(View v) {
        SandData("35.01580", "126.71083",R.raw.jeollanamnajucctv,R.raw.nulll,"나주");
    }

    public void onClickSuncheon(View v) {
        SandData("34.95053", "127.48744",R.raw.jeollanamsuncheoncctv,R.raw.jeonnamnamsuncheonlamp,"순천");
    }
    public void onClickMokpo(View v) {
        SandData("34.81190", "126.39309",R.raw.jeollanammokpocctv,R.raw.jeonnamnammokpolamp,"목포");
    }

    public void onClickJangheung(View v) {
        SandData("34.68171", "126.90703",R.raw.jeollanamjangheungcctv,R.raw.nulll,"장흥");
    }
    public void onClickBoseong(View v) {
        SandData("34.77150", "127.08002",R.raw.jeollanamboseongcctv,R.raw.jeonnamnamboseonglamp,"보성");
    }
    public void onClickYeosu(View v) {
        SandData("34.76043", "127.66230",R.raw.jeollanamyeosucctv,R.raw.jeonnamnamyeosulamp,"여수");
    }
    public void onClivkJangseong(View v) {
        SandData("34.97916", "126.80235",R.raw.jeollanamjangseongcctv,R.raw.jeonnamnamjangseonglamp,"장성");
    }

    public void onClickGoheung(View v) {
        SandData("34.62664", "127.38054",R.raw.jeollanamgoheungcctv,R.raw.nulll,"고흥");
    }

    public void onClickJindo(View v) {
        SandData("34.48683", "126.26354",R.raw.nulll,R.raw.nulll,"진도");
    }
    public void onClickHaenam(View v) {
        SandData("34.57362", "126.59951",R.raw.jeollanamhaenamcctv,R.raw.jeonnamnamhaenamlamp,"해남");
    }
    public void onClickWando(View v) {
        SandData("34.31096", "126.75539",R.raw.jeollanamwandocctv,R.raw.jeonnamnamwandolamp,"완도");
    }

    public void onClickHampyeong(View v) {
        SandData("35.06590", "126.51667",R.raw.jeollanamhampyeongcctv,R.raw.nulll,"함평");
    }

    public void onClickMuan(View v) {
        SandData("34.99043", "126.48168",R.raw.jeollanammuancctv,R.raw.jeonnamnammuanlamp,"무안");
    }


    public void onClickDammyang(View v) {
        SandData("35.32121", "126.98822",R.raw.jeollanamdamyangcctv,R.raw.nulll,"담양");
    }


    public void onClickHwasun(View v) {
        SandData("35.06456", "126.98651",R.raw.jeollanamhwasuncctv,R.raw.jeonnamnamhwasunlamp,"화순");
    }

    public void onClickYeongam(View v) {
        SandData("34.80019", "126.69680",R.raw.jeollanamyeongamcctv,R.raw.jeonnamnamyeongamlamp,"영암");
    }

    public void onClickGangjin(View v) {
        SandData("34.64199", "126.76700",R.raw.jeollanamgangjincctv,R.raw.nulll,"강진");
    }

    public void onCLickSinan(View v) {
        SandData("34.83362", "126.35140",R.raw.jeollanamsinancctv,R.raw.jeonnamnamsinanlamp,"신안");
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