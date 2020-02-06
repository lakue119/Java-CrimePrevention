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

public class gyunggiactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "경기도";
    private MainActivity mainActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyunggiactivity);

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
    public void onClickYeoncheon(View v)
    {
        SandData("38.10547", "127.07915",R.raw.gyunggiyeoncheoncctv,R.raw.gyeonggiyeoncheonlamp,"연천");
    }

    public void onClickPocheon(View v)
    {
        SandData("37.89497", "127.20038",R.raw.gyunggipocheoncctv,R.raw.gyeonggipocheonlamp,"포천");
    }
    public void onClickGapyeong(View v)
    {
        SandData("37.73024", "127.41014",R.raw.gyunggigapyeongcctv,R.raw.gyeonggigapyeonglamp,"가평");
    }
    public void onClickDongducheon(View v)
    {
        SandData("37.90360", "127.06030",R.raw.gyunggidongducheoncctv,R.raw.gyeonggidongducheonlamp,"동두천");

    }

    public void onClickYangju(View v)
    {
        SandData("37.78524", "127.04578",R.raw.gyunggiyangjucctv,R.raw.gyeonggiyangjulamp,"양주");

    }

    public void onClickPaju(View v)
    {
        SandData("37.76000", "126.77991",R.raw.gyunggipajucctv,R.raw.gyeonggipajulamp,"파주");

    }

    public void onClickUijeongbu(View v)
    {
        SandData("37.73806", "127.03379",R.raw.gyunggiuijeongbucctv,R.raw.gyeonggiuijeongbulamp,"의정부");

    }

    public void onClickGimpo(View v)
    {
        SandData("37.61517", "126.71571",R.raw.gyunggigimpocctv,R.raw.gyeonggigimpolamp,"김포");

    }

    public void onClickGoyang(View v)
    {
        SandData("37.65841", "126.83196",R.raw.gyunggigoyangcctv,R.raw.gyeonggigoyanglamp,"고양");

    }

    public void onClickNamyangju(View v)
    {
        SandData("37.63604", "127.21650",R.raw.gyungginamyangjucctv,R.raw.gyeongginamyangjulamp,"남양주");

    }

    public void onClickGuri(View v)
    {
        SandData("37.59433", "127.12964",R.raw.gyunggiguricctv,R.raw.gyeonggigurilamp,"구리");

    }
    public void onClickYangpyeong(View v)
    {
        SandData("37.53298", "127.55315",R.raw.gyunggiyangpyeongcctv,R.raw.gyeonggiyangpyeonglamp,"양평");

    }
    public void onClickHanam(View v)
    {
        SandData("37.53905", "127.21554",R.raw.gyunggihanamcctv,R.raw.gyeonggihanamlamp,"하남");

    }
    public void onClickYeoju(View v)
    {
        SandData("37.29832", "127.63732",R.raw.gyunggiyeojucctv,R.raw.nulll,"여주");

    }

    public void onClickGyeonggido_Gwangju(View v)
    {
        SandData("37.42931", "127.25480",R.raw.gyunggigwangjucctv,R.raw.gyeonggigwangjulamp,"광주");

    }

    public void onClickIcheon(View v)
    {
        SandData("37.27215", "127.43502",R.raw.gyunggiicheoncctv,R.raw.gyeonggiicheonlamp,"이천");

    }

    public void onClickAnseong(View v)
    {

        SandData("37.00803", "127.27978",R.raw.gyunggianseongcctv,R.raw.nulll,"안성");

    }

    public void onClickYongin(View v)
    {
        SandData("37.24087", "127.17790",R.raw.gyunggiyongincctv,R.raw.gyeonggiyonginlamp,"용인");

    }

    public void onClickPyeongtaek(View v)
    {
        SandData("36.99230", "127.11254",R.raw.gyunggipyeongtaekcctv,R.raw.gyeonggipyeongtaeklamp,"평택");

    }

    public void onClickHwaseong(View v)
    {
        SandData("37.19966", "126.83130",R.raw.gyunggihwaseongcctv,R.raw.gyeonggihwaseonglamp,"화성");

    }

    public void onClickOsan(View v)
    {
        SandData("37.14977", "127.07747",R.raw.gyunggiosancctv,R.raw.gyeonggiosanlamp,"오산");

    }

    public void onClickBucheon(View v)
    {
        SandData("37.50350", "126.76629",R.raw.gyunggibucheoncctv,R.raw.gyeonggibucheonlamp,"부천");

    }

    public void onClickGwacheon(View v)
    {
        SandData("37.42939", "126.98743",R.raw.gyunggigwacheoncctv,R.raw.gyeonggigwacheonlamp,"과천");

    }

    public void onClickGwangmyeong(View v)
    {
        SandData("37.47852", "126.86464",R.raw.gyunggigwangmyeongcctv,R.raw.gyeonggigwangmyeonglamp,"광명");

    }

    public void onClickSiheung(View v)
    {
        SandData("37.38019", "126.80302",R.raw.gyunggisiheungcctv,R.raw.gyeonggisiheunglamp,"신흥");

    }

    public void onClickAnsan(View v) {
        SandData("37.31947", "126.81261", R.raw.gyunggiansancctv,R.raw.gyeonggiansanlamp,"안산");

    }
    public void onClickSuwon(View v)
    {
        SandData("37.26345", "127.02880",R.raw.gyunggisuwoncctv,R.raw.gyeonggisuwonlamp,"수원");
    }

    public void onClickSeongnam(View v)
    {
        SandData("37.42019", "127.12631",R.raw.gyunggiseongnamcctv,R.raw.gyeonggiseongnamlamp,"성남");

    }
    public void onClickUiwang(View v)
    {
        SandData("37.34479", "126.96827",R.raw.gyunggiuiwangcctv,R.raw.gyeonggiuiwanglamp,"의왕");

    }

    public void onClickAnyang(View v)
    {
        SandData("37.39430", "126.95685",R.raw.gyunggianyangcctv,R.raw.gyeonggianyanglamp,"안양");

    }

    public void onClickGunpo(View v)
    {
        SandData("37.36102", "126.93532",R.raw.gyunggigunpocctv,R.raw.gyeonggigunpolamp,"군포");

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
