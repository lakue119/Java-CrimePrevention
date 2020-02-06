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

public class inchunactivity extends AppCompatActivity {
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;


    private String stringcctv="";
    private String stringlamp="";
    private String capital = "인천광역시";

    private MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inchunactivity);

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
    public void onClickGanghwa(View v)
    {
        SandData("37.74652", "126.48807",R.raw.incheonganghwacctv,R.raw.nulll,"강화");

    }

    public void onClickIncheon_Seogu(View v)
    {
        SandData("37.60219", "126.66135",R.raw.incheonseogucctv,R.raw.nulll,"서구");

    }

    public void onClickGyeyang(View v)
    {
        SandData("37.53747", "126.73779",R.raw.incheongyeyangcctv,R.raw.incheongyeyanglamp,"계양구");

    }
    public void onClickBupyeong(View v)
    {
        SandData("37.50703", "126.72185",R.raw.incheonbupyeongcctv,R.raw.incheonbupyeonglamp,"부평구");

    }

    public void onClickIncheon_Donggu(View v)
    {
        SandData("37.47372", "126.64355",R.raw.incheondonggucctv,R.raw.nulll,"동구");

    }

    public void onClickDaegu_Namdonggu(View v)
    {
        SandData("37.47372", "126.64355",R.raw.incheonnamdonggucctv,R.raw.nulll,"남동구");

    }
    public void onClickIncheon_Namgu(View v)
    {
        SandData("37.44725", "126.73179",R.raw.incheonnamgucctv,R.raw.incheonnamgulamp,"남구");

    }

    public void onClickYeonsu(View v)
    {
        SandData("37.41015", "126.67830",R.raw.incheonyeonsucctv,R.raw.incheonyeonsulamp,"연수구");

    }

    public void onClickIncheon_Junggu(View v)
    {
        SandData("37.47371", "126.62152",R.raw.incheonjunggucctv,R.raw.incheonjunggulamp,"중구");

    }

    public void onClickOngjin(View v)
    {
        SandData("37.44660", "126.63670",R.raw.incheonongjincctv,R.raw.nulll,"옹진");

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