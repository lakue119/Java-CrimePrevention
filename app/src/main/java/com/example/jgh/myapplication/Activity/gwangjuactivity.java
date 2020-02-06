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

public class gwangjuactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "광주광역시";
    private MainActivity mainActivity = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwangjuactivity);

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

    public void onClickBukgu(View v) {
        SandData("35.17432", "126.91214",R.raw.gwangjubukgucctv,R.raw.gwangjugwangsancctv,"북구");
    }


    public void onClickGwangsan(View v) {
        SandData("35.13964", "126.79352",R.raw.gwangjugwangsancctv,R.raw.gwangjugwangsanlamp,"광산구");
    }


    public void onClickGwangju_Seogu(View v) {
        SandData("35.15195", "126.89029",R.raw.gwangjuseogucctv,R.raw.nulll,"서구");
    }


    public void onClickGwangju_Donggu(View v) {
        SandData("35.14614", "126.92313",R.raw.gwangjudonggucctv,R.raw.nulll,"동구");
    }


    public void onClickGwangju_Namgu(View v) {
        SandData("35.13289", "126.90242",R.raw.gwangjunamgucctv,R.raw.gwangjunamgulamp,"남구");
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

