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

public class busanactivity extends AppCompatActivity {

    // ArrayAdapter<String> arrayAdapter;
    private ArrayList<MarkData> markdata;
    private ArrayList<MarkData> lampdata;

    private String stringcctv="";
    private String stringlamp="";

    private String capital = "부산광역시";

    private MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busanactivity);
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


    public void onClickGijang(View v)
    {
        SandData("35.24444","129.22219",R.raw.busangijangcctv,R.raw.busangijanglamp,"기장군");
    }
    public  void onClickGeumjeong(View v)
    {
        SandData("35.24304","129.09216",R.raw.busangeumjeongcctv,R.raw.busangeumjeonglamp,"금정");
    }
    public void onClickBusan_Bukgu(View v)
    {
        SandData("35.19722","128.99016",R.raw.busanbukgucctv,R.raw.busanbukgulamp,"북구");
    }
    public void onClickDongnae(View v)
    {
        SandData("35.20502","129.08359",R.raw.busandongnaecctv,R.raw.busandongnaelamp,"동래구");
    }
    public void onClickHaeundae(View v)
    {
        SandData("35.16315","129.16356",R.raw.busanhaeundaecctv,R.raw.busanhaeundaelamp,"해운대구");
    }
    public void onClickYeonje(View v)
    {
        SandData("35.18107","129.07588",R.raw.busanyeonjecctv,R.raw.busanyeonjelamp,"연제");
    }
    public void onClickSuyeong(View v)
    {
        SandData("35.14549","129.11305",R.raw.busansuyeongcctv,R.raw.busansuyeonglamp,"수영구");
    }
    public void onClickJingu(View v)
    {
        SandData("35.16284","129.05311",R.raw.busanjingucctv,R.raw.busanjingulamp,"진구구");
    }
    public void onClickSasang(View v)
    {
        SandData("35.18125","128.98469",R.raw.busansasangcctv,R.raw.busansasanglamp,"사상구");
    }
    public void onClickBusan_Gangseo(View v)
    {
        SandData("35.21220","128.98058",R.raw.busangangseocctv,R.raw.busangangseolamp,"강서구");
    }
    public void onClickBusan_Donggu(View v)
    {
        SandData("35.12929","129.04528",R.raw.busandonggucctv,R.raw.nulll,"동구");
    }
    public void onClickBusan_Namgu(View v)
    {
        SandData("35.13651","129.08444",R.raw.busannamgucctv,R.raw.busannamgulamp,"남구");
    }
    public void onClickSaha(View v)
    {
        SandData("35.10451","128.97480",R.raw.busansahacctv,R.raw.busansahalamp,"사하구");
    }
    public void onClickBusan_Seogu(View v)
    {
        SandData("35.09719","129.02348",R.raw.busanseogucctv,R.raw.busanseogulamp,"서구");
    }
    public void onClickYeongdo(View v)
    {
        SandData("35.09122","129.06791",R.raw.nulll,R.raw.busanyeongdolamp,"영도");
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


