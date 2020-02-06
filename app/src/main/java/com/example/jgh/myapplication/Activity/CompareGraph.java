package com.example.jgh.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jgh.myapplication.Model.ArraylocalData;
import com.example.jgh.myapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;

public class CompareGraph extends AppCompatActivity {

    private MainActivity mainActivity = new MainActivity();
    public static ArrayList<ArraylocalData> arraylocaldata;
    BarChart chart1 ;
    ArrayList<BarEntry> BARENTRY1 ;
    ArrayList<String> BarEntryLabels1 ;
    BarDataSet Bardataset1 ;
    BarData BARDATA1 ;

    BarChart chart2 ;
    ArrayList<BarEntry> BARENTRY2 ;
    BarDataSet Bardataset2 ;
    BarData BARDATA2 ;

    BarChart chart3 ;
    ArrayList<BarEntry> BARENTRY3 ;
    BarDataSet Bardataset3 ;
    BarData BARDATA3 ;

    BarChart chart4 ;
    ArrayList<BarEntry> BARENTRY4 ;
    BarDataSet Bardataset4 ;
    BarData BARDATA4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_graph);

        arraylocaldata = new ArrayList<ArraylocalData>();
        arraylocaldata.addAll(MainActivity.solution_arraylocalData);

        chart1 = (BarChart) findViewById(R.id.chart1);
        chart2 = (BarChart) findViewById(R.id.chart2);
        chart3 = (BarChart) findViewById(R.id.chart3);
        chart4 = (BarChart) findViewById(R.id.chart4);

        BarEntryLabels1 = new ArrayList<String>();
        AddValuesToBarEntryLabels();

        //ChangeData();
        ForEachCctvLamp();

        Descendingcrime descendingcrime = new Descendingcrime();
        Collections.sort(arraylocaldata,descendingcrime);

        Showgraph1();
        Showgraph2();
        Showgraph3();
        Showgraph4();
    }

    public void Showgraph1(){

        chart1.removeAllViews();

        BARENTRY1 = new ArrayList<>();
        AddValuesToBARENTRY1();

        Bardataset1 = new BarDataSet(BARENTRY1, "(지역순)범죄 발생률");
        BARDATA1 = new BarData(BarEntryLabels1, Bardataset1);

        Bardataset1.setColors(ColorTemplate.COLORFUL_COLORS);

        chart1.setDrawBarShadow(true);
        chart1.setData(BARDATA1);
        chart1.animateY(2000);
    }

    public void AddValuesToBARENTRY1(){
        float lg1 = 0;

        BARENTRY1.clear();

        for(int i=0;i<arraylocaldata.size();i++){
            double doublecrime = arraylocaldata.get(i).getCrimeData();
            lg1 = Math.round(doublecrime);
            BARENTRY1.add(new BarEntry(lg1, i));
        }

    }
    public void AddValuesToBarEntryLabels(){

        BarEntryLabels1.clear();

        for(int i=0;i<arraylocaldata.size();i++){
            BarEntryLabels1.add(String.valueOf(arraylocaldata.get(i).getLocalData()));
        }

    }

    public void Showgraph2(){

        BARENTRY2 = new ArrayList<>();
        AddValuesToBARENTRY2();

        Bardataset2 = new BarDataSet(BARENTRY2, "(지역순)10,000명당 CCTV개수");
        BARDATA2 = new BarData(BarEntryLabels1, Bardataset2);

        Bardataset2.setColors(ColorTemplate.COLORFUL_COLORS);

        chart2.setDrawBarShadow(true);
        chart2.setData(BARDATA2);
        chart2.animateY(2000);
    }
    public void AddValuesToBARENTRY2(){
        float lg1 = 0;
        BARENTRY2.clear();
        for(int i=0;i<arraylocaldata.size();i++){
            double doublecrime = arraylocaldata.get(i).getForEachCctvData();
            lg1 = Math.round(doublecrime);
            BARENTRY2.add(new BarEntry(lg1, i));
        }

    }

    public void Showgraph3(){

        BARENTRY3 = new ArrayList<>();
        AddValuesToBARENTRY3();

        Bardataset3 = new BarDataSet(BARENTRY3, "(지역순)10,000명당 보안등개수");
        BARDATA3 = new BarData(BarEntryLabels1, Bardataset3);

        Bardataset3.setColors(ColorTemplate.COLORFUL_COLORS);

        chart3.setDrawBarShadow(true);
        chart3.setData(BARDATA3);
        chart3.animateY(2000);
    }
    public void AddValuesToBARENTRY3(){
        float lg1 = 0;
        BARENTRY3.clear();
        for(int i=0;i<arraylocaldata.size();i++){
            double doublecrime = arraylocaldata.get(i).getForEachLampData();
            lg1 = Math.round(doublecrime);
            BARENTRY3.add(new BarEntry(lg1, i));
        }
    }

    public void Showgraph4(){

        BARENTRY4 = new ArrayList<>();
        AddValuesToBARENTRY4();

        Bardataset4 = new BarDataSet(BARENTRY4, "(지역순)10,000명당 CCTV,보안등 통합");
        BARDATA4 = new BarData(BarEntryLabels1, Bardataset4);

        Bardataset4.setColors(ColorTemplate.COLORFUL_COLORS);

        chart4.setDrawBarShadow(true);
        chart4.setData(BARDATA4);
        chart4.animateY(2000);
    }
    public void AddValuesToBARENTRY4(){
        float lg1 = 0;
        BARENTRY4.clear();
        for(int i=0;i<arraylocaldata.size();i++){
            double doublecrime =arraylocaldata.get(i).getForEachCctvData()*14+arraylocaldata.get(i).getForEachLampData();
            lg1 = Math.round(doublecrime);
            BARENTRY4.add(new BarEntry(lg1, i));
        }
    }
    public void ForEachCctvLamp(){
        for(int i=0;i<arraylocaldata.size();i++){
            arraylocaldata.get(i).setForEachCctvData((double)arraylocaldata.get(i).getCctvData()*10000/arraylocaldata.get(i).getPopulationData());
            arraylocaldata.get(i).setForEachLampData((double)arraylocaldata.get(i).getLampData()*10000/arraylocaldata.get(i).getPopulationData());
        }
    }
    public void onClickshow(View v)
    {
        Intent intent = new Intent(getApplicationContext(), DataAnalysisGraph.class);
        startActivity(intent);
    }


}
