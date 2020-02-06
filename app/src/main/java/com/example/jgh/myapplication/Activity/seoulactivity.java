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

public class seoulactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";
    private String capital = "서울특별시";

    private MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seoulactivity);

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
    public void onClickDobong(View v)
    {
        SandData("37.66868","127.04728",R.raw.seouldobongcctv,R.raw.seouldobonglamp,"도봉구");
    }

    public void onClickNowon(View v)
    {
        SandData("37.65399","127.05634",R.raw.seoulnowoncctv,R.raw.seoulnowonlamp,"노원구");
    }
    public void onClickGangbuk(View v)
    {
        SandData("37.63969","127.02570",R.raw.seoulgangbukcctv,R.raw.seoulgangbuklamp,"강북구");
    }

    public void onClickJungnang(View v)
    {
        SandData("37.60650","127.09260",R.raw.seouljungrangcctv,R.raw.seouljungnanglamp,"중랑구");
    }

    public  void onClickSeongbuk(View v)
    {
        SandData("37.58946","127.01685",R.raw.seoulseongbukcctv,R.raw.seoulseongbuklamp,"성북구");
    }

    public void onClickEunpyeong(View v)
    {
        SandData("37.60279","126.92916",R.raw.seouleunpyeongcctv,R.raw.seouleunpyeonglamp,"은평구");
    }
    public  void onClickJongno(View v)
    {
        SandData("37.57303","126.97969",R.raw.seouljongrocctv,R.raw.seouljongnolamp,"종로구");

    }
    public  void onClickDongdaemun(View v)
    {
        SandData("37.57669","127.07151",R.raw.seouldongdaemuncctv,R.raw.seouldongdaemunlamp,"동대문구");
    }

    public void onClickSeodaemun(View v)
    {
        SandData("37.58011","126.93415",R.raw.seoulseodaemuncctv,R.raw.seoulseodaemunlamp,"서대문구");
    }

    public  void onClickSeoul_Junggu(View v)
    {
        SandData("37.56380","126.99757",R.raw.seouljunggucctv,R.raw.seouljunggulamp,"중구");
    }

    public void onClickGangdong(View v)
    {
        SandData("37.53025","127.12401",R.raw.seoulgangdongcctv,R.raw.seoulgangdonglamp,"강동구");

    }

    public void onClickGwangjin(View v)
    {
        SandData("37.53791","127.08223",R.raw.seoulgwangjincctv,R.raw.seoulgwangjinlamp,"광진");
    }

    public void onClickSeongdong(View v)
    {
        SandData("37.56341","127.03691",R.raw.seoulseongdongcctv,R.raw.seoulseongdonglamp,"성동구");
    }

    public void onClickSongpa(View v)
    {
        SandData("37.51446","127.10597",R.raw.seoulsongpacctv,R.raw.seoulsongpalamp,"송파구");
    }

    public void onClickGangnam(View v)
    {
        SandData("37.49954","127.03989",R.raw.seoulgangnamcctv,R.raw.seoulgangnamlamp,"강남구");
    }

    public void onClickSeocho(View v)
    {
        SandData("37.48362","127.03259",R.raw.seoulseochocctv,R.raw.seoulseocholamp,"서초구");
    }

    public void onClickGwanak(View v)
    {
        SandData("37.47821","126.95150",R.raw.seoulgwanakcctv,R.raw.seoulgwanaklamp,"관악구");
    }

    public void onClickGeumcheon(View v)
    {
        SandData("37.45690","126.89538",R.raw.seoulgeumcheoncctv,R.raw.seoulgeumcheonlamp,"금천구");
    }
    public void onClickGuro(View v)
    {
        SandData("37.49547","126.88752",R.raw.seoulgurocctv,R.raw.seoulgurolamp,"구로구");
    }

    public void onClickYangchun(View v)
    {
        SandData("37.51711","126.86670",R.raw.seoulyangchuncctv,R.raw.seoulyangchunlamp,"양천구");
    }

    public void onClickSeoul_Gangseo(View v)
    {
        SandData("37.56059","126.85968",R.raw.seoulgangseocctv,R.raw.seoulgangseolamp,"강서구");
    }

    public void onClickYeongdeungpo(View v)
    {
        SandData("37.52641","126.89626",R.raw.seoulyeongdeungpocctv,R.raw.seoulyeongdeungpolamp,"영등포구");
    }

    public void onClickDongjak(View v)
    {
        SandData("37.51246","126.93950",R.raw.seouldongjakcctv,R.raw.seouldongjaklamp,"동작구");
    }

    public void onClickYongsan(View v)
    {
        SandData("37.53248","126.99055",R.raw.seoulyongsancctv,R.raw.nulll,"용산");
    }

    public void onClickMapo(View v)
    {
        SandData("37.56364","126.90802",R.raw.seoulmapocctv,R.raw.seoulmapolamp,"마포구");
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