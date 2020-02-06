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

public class gyungbukactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "경상북도";

    private MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyungbukactivity);

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
    public void onClickUljin(View v)
    {
        SandData("36.99306","129.40065",R.raw.gyungbukuljincctv,R.raw.gyeongbukuljinlamp,"울진");
    }

    public void onClickBonghwa(View v)
    {
        SandData("36.89313","128.73252",R.raw.gyungbukbonghwacctv,R.raw.gyeongbukbonghwalamp,"봉화");
    }

    public void onClickYeongju(View v)
    {
        SandData("36.80564","128.62400",R.raw.gyungbukyeongjucctv,R.raw.gyeongbukyeongjulamp,"영주");
    }

    public void onClickYeongyang(View v)
    {
        SandData("36.66672","129.11244",R.raw.gyungbukyeongyangcctv,R.raw.nulll,"영양");
    }
    public void onClickAndong(View v)
    {
        SandData("36.56811","128.72859",R.raw.gyungbukandongcctv,R.raw.gyungbukandonglamp,"안동");
    }

    public void onClickYecheon(View v)
    {
        SandData("36.65770","128.45298",R.raw.gyungbukyecheoncctv,R.raw.gyeongbukyecheonlamp,"예천");
    }

    public void onClickMungyeong(View v)
    {
        SandData("36.58669","128.18985",R.raw.gyungbukmungyeongcctv,R.raw.gyeongbukmungyeonglamp,"문경");
    }

    public void onClickYeongdeok(View v)
    {
        SandData("36.41492","129.36577",R.raw.gyungbukyeongdeokcctv,R.raw.nulll,"영덕");
    }

    public void onClickCheongsong(View v)
    {
        SandData("36.43696","129.05516",R.raw.gyungbukcheongsongcctv,R.raw.gyeongbukcheongsonglamp,"청송");
    }

    public void onClickUiseong(View v)
    {
        SandData("36.35273","128.69718",R.raw.gyungbukuiseongcctv,R.raw.gyeongbukuiseonglamp,"의성");
    }

    public void onClickSangju(View v)
    {
        SandData("36.41103","128.15909",R.raw.gyungbuksangjucctv,R.raw.gyeongbuksangjulamp,"상주");
    }
    public void onClickGumi(View v)
    {
        SandData("36.11957","128.34430",R.raw.gyungbukgumicctv,R.raw.gyeongbukgumilamp,"구미");
    }

    public void onClickPohang(View v)
    {
        SandData("36.0190333","129.3433898",R.raw.gyungbukpohangcctv,R.raw.gyeongbukpohanglamp,"포항");
    }
    public void onClickGunwi(View v)
    {
        SandData("36.24302","128.57299",R.raw.gyungbukgunwicctv,R.raw.nulll,"군위");
    }
    public void onClickGimcheon(View v)
    {
        SandData("36.13988","128.11364",R.raw.gyungbukgimcheoncctv,R.raw.nulll,"김천");
    }
    public void onClickChilgok(View v)
    {
        SandData("35.99545","128.40148",R.raw.gyungbukchilgokcctv,R.raw.gyeongbukchilgoklamp,"칠곡");
    }

    public void onClickYeongcheon(View v)
    {
        SandData("35.97328","128.93865",R.raw.gyungbukyeongcheoncctv,R.raw.gyeongbukyeongcheonlamp,"영천");
    }

    public void onClickSeongju(View v)
    {
        SandData("35.91917","128.28299",R.raw.gyungbukseongjucctv,R.raw.gyeongbukseongjulamp,"성주");
    }

    public void onClickGyeongsan(View v)
    {
        SandData("35.82512","128.74140",R.raw.gyungbukgyeongsancctv,R.raw.gyeongbukgyeongsanlamp,"경산");
    }

    public void onClickGyeongju(View v)
    {
        SandData("35.84660","129.21063",R.raw.gyungbukgyeongjucctv,R.raw.nulll,"경주");
    }

    public void onClickCheongdo(View v)
    {
        SandData("35.64723","128.73385",R.raw.gyungbukcheongdocctv,R.raw.gyeongbukcheongdolamp,"청도");
    }

    public void onClickGoryeong(View v)
    {
        SandData("35.72605","128.26293",R.raw.gyungbukgoryeongcctv,R.raw.nulll,"고령");
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
