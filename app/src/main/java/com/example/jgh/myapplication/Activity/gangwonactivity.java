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

public class gangwonactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "강원도";
    private MainActivity mainActivity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gangwonactivity);

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
    public void onClickGoseong(View v)
    {
        SandData("38.38061", "128.46788",R.raw.gangwongoseongcctv,R.raw.nulll,"고성");
    }

    public void onClickSokcho(View v)
    {
        SandData("38.20702", "128.59196",R.raw.gangwonsokchocctv,R.raw.nulll,"속초");
    }

    public void onClickYanggu(View v)
    {
        SandData("38.10576", "127.98159",R.raw.gangwonyanggucctv,R.raw.gangwondoyanggulamp,"양구");
    }

    public void onClickHwacheon(View v)
    {
        SandData("38.10616", "127.70820",R.raw.gangwonhwacheoncctv,R.raw.nulll,"화천");
    }

    public void onClickCheorwon(View v)
    {
        SandData("38.14676", "127.31340",R.raw.gangwoncheorwoncctv,R.raw.nulll,"철원");
    }
    public void onClickYangyang(View v)
    {
        SandData("38.07546", "128.61901",R.raw.gangwonyangyangcctv,R.raw.nulll,"양양");
    }
    public void onClickInje(View v)
    {
        SandData("38.06969", "128.17035",R.raw.gangwoninjecctv,R.raw.gangwondoinjelamp,"인제");
    }
    public void onClickChuncheon(View v)
    {
        SandData("37.88012", "127.72895",R.raw.gangwonchuncheoncctv,R.raw.gangwondochuncheonlamp,"춘천");
    }

    public void onClickHongcheon(View v)
    {
        SandData("37.69720", "127.88869",R.raw.gangwonhongcheoncctv,R.raw.gangwondohongcheonlamp,"홍천");
    }

    public void onClickGangneung(View v)
    {
        SandData("37.75206", "128.87597",R.raw.gangwongangneungcctv,R.raw.gangwongangneunglamp,"강릉");
    }
    public void onClickHoengseong(View v)
    {
        SandData("37.48602", "128.17117",R.raw.gangwonhoengseongcctv,R.raw.gangwondohoengseonglamp,"횡성");
    }

    public void onClickPyeongchang(View v)
    {
        SandData("37.37077", "128.39024",R.raw.nulll,R.raw.nulll,"평창");
    }

    public void onClickDonghae(View v)
    {
        SandData("37.52693", "129.11402",R.raw.gangwondonghaecctv,R.raw.gangwondodonghaelamp,"동해");
    }

    public void onClickSamcheok(View v)
    {
        SandData("37.44991", "129.16500",R.raw.gangwonsamcheokcctv,R.raw.gangwondosamcheoklamp,"삼척");
    }
    public void onClickTaebaek(View v)
    {
        SandData("37.16420", "128.98656", R.raw.gangwontaebaekcctv,R.raw.gangwondotaebaeklamp,"태백");
    }

    public void onClickJeongseon(View v)
    {
        SandData("37.38064", "128.66082",R.raw.gangwonjeongseoncctv,R.raw.nulll,"정선");
    }

    public void onClickYeongwol(View v)
    {
        SandData("37.18371", "128.46180",R.raw.gangwonyeongwolcctv,R.raw.gangwonyeongwollamp,"영월");
    }

    public void onClickWonju(View v)
    {
        SandData("37.34192", "127.91973",R.raw.gangwonwonjucctv,R.raw.gangwondowonjulamp,"원주");

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
