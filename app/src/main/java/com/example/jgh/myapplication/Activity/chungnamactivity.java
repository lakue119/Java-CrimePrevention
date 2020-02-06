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

public class chungnamactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "충청남도";

    private MainActivity mainActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chungnamactivity);


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
    public void onClickTaean(View v)
    {
        SandData("36.74557", "126.29794",R.raw.chungnamtaeancctv,R.raw.chungnamtaeanlamp,"태안");

    }

    public void onClickSeosan(View v)
    {
        SandData("36.78490", "126.45031",R.raw.chungnamseosancctv,R.raw.nulll,"서산");

    }
    public void onClickDangjin(View v)
    {
        SandData("36.88979", "126.64588",R.raw.chungnamdangjincctv,R.raw.chungnamdangjinlamp,"당진");

    }

    public void onClickAsan(View v)
    {
        SandData("36.79003", "127.00255",R.raw.chungnamasancctv,R.raw.chungnamasanlamp,"아산");

    }

    public void onClickCheonan(View v)
    {
        SandData("36.80334", "127.11215",R.raw.chungnamcheonancctv,R.raw.chungnamcheonanlamp,"천안");

    }

    public void onClickYesan(View v)
    {
        SandData("36.68168", "126.84266",R.raw.chungnamyesancctv,R.raw.chungnamyesanlamp,"예산");

    }

    public void onClickSejong(View v)
    {
        SandData("36.48009", "127.28922",R.raw.chungnamsejongcctv,R.raw.chungnamsejonglamp,"세종시");

    }

    public void onClickHongseong(View v)
    {
        SandData("36.60131", "126.66083",R.raw.chungnamhongseongcctv,R.raw.chungnamhongseonglamp,"홍성");

    }

    public void onClickGongju(View v)
    {
        SandData("36.44662", "127.11905",R.raw.chungnamgongjucctv,R.raw.nulll,"공주");
    }

    public void onClickCheongyang(View v)
    {
        SandData("36.45910", "126.80229",R.raw.chungnamcheongyangcctv,R.raw.nulll,"청양");

    }

    public void onClickBoryeong(View v)
    {
        SandData("36.33361", "126.61288",R.raw.chungnamboryeongcctv,R.raw.chungnamboryeonglamp,"보령");

    }

    public void onClickBuyeo(View v)
    {
        SandData("36.27574", "126.90977",R.raw.chungnambuyeocctv,R.raw.chungnambuyeolamp,"부여");

    }

    public void onClickGyeryong(View v)
    {
        SandData("36.27449", "127.24854",R.raw.chungnamgyeryongcctv,R.raw.nulll,"계룡");

    }

    public void onClickSeocheon(View v)
    {
        SandData("36.08025", "126.69128",R.raw.chungnamseocheoncctv,R.raw.chungnamseocheonlamp,"서천");

    }
    public void onClickNonsan(View v)
    {
        SandData("36.18722", "127.09868",R.raw.chungnamnonsancctv,R.raw.chungnamnonsanlamp,"논산");

    }

    public void onClickGeumsan(View v)
    {
        SandData("36.10890", "127.48780",R.raw.chungnamgeumsancctv,R.raw.nulll,"금산");

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
