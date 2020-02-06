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

public class chungbukactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "충청북도";

    private MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chungbukactivity);

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
    public void onClickDanyang(View v)
    {
        SandData("36.98465", "128.36558",R.raw.chungbukdanyangcctv,R.raw.chungbukdanyanglamp,"단양");

    }

    public void onClickJeungpyeong(View v)
    {
        SandData("36.785345", "127.5815070",R.raw.chungbukjeungpyeongcctv,R.raw.nulll,"증평");

    }

    public void onClickJecheon(View v)
    {
        SandData("37.13257", "128.19100",R.raw.chungbukjecheoncctv,R.raw.chungbukjecheonlamp,"제천");

    }

    public void onClickChungju(View v)
    {
        SandData("36.98825", "127.92613",R.raw.chungbukchungjucctv,R.raw.chungbukchungjulamp,"충주");

    }

    public void onClickEumseong(View v)
    {
        SandData("36.94029", "127.69051",R.raw.chungbukeumseongcctvcsv,R.raw.chungbukeumseonglamp,"음성");

    }

    public void onClickGoesan(View v)
    {
        SandData("36.81542", "127.78669",R.raw.chungbukgoesancctv,R.raw.chungbukgoesanlamp,"괴산");

    }

    public void onClickJincheon(View v)
    {
        SandData("36.85529", "127.43503",R.raw.chungbukjincheoncctv,R.raw.chungbukjincheonlamp,"진천");

    }

    public void onClickCheongju(View v)
    {
        SandData("36.62953", "127.47421",R.raw.chungbukcheongjucctv,R.raw.nulll,"청주");

    }

    public void onClickBoeun(View v)
    {
        SandData("36.48945", "127.72952",R.raw.chungbukboeuncctv,R.raw.chungbukboeunlamp,"보은");

    }

    public void onClickOkcheon(View v)
    {
        SandData("36.30669", "127.57113",R.raw.chungbukokcheoncctv,R.raw.chungbukokcheonlamp,"옥산");

    }

    public void onClickYeongdong(View v)
    {
        SandData("36.17493", "127.78320",R.raw.chungbukyeongdongcctv,R.raw.chungbukyeongdonglamp,"영동");

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
