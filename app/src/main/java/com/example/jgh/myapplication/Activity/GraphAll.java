package com.example.jgh.myapplication.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.jgh.myapplication.Model.ArraylocalData;
import com.example.jgh.myapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


public class GraphAll extends AppCompatActivity {

    public static ArrayList<ArraylocalData> arraylocaldata;
    public static ArrayList<ArraylocalData> arraylocaldata1;

    Spinner spi_txtopder;
    Spinner spi_chartorder;
    Spinner spi_capital1 ;

    ArrayAdapter<CharSequence> chartadapter;
    ArrayAdapter<CharSequence> chartorderadapter;
    ArrayAdapter<CharSequence> txtorderadapter;


    TextView txt_Maxorder;
    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_all);
        arraylocaldata = new ArrayList<ArraylocalData>();
        arraylocaldata1 = new ArrayList<ArraylocalData>();
        //region 화면구성
        chart = (BarChart) findViewById(R.id.chart1);
        txt_Maxorder = (TextView) findViewById(R.id.maxorder);
        txt_Maxorder.setMovementMethod(new ScrollingMovementMethod());

        spi_capital1 = (Spinner) findViewById(R.id.sin_showchart);
        spi_chartorder = (Spinner) findViewById(R.id.sin_chartorder);
        spi_txtopder = (Spinner) findViewById(R.id.sin_txtorder);

        chartadapter = ArrayAdapter.createFromResource(this,
                R.array.Chartdata, android.R.layout.simple_spinner_item);
        chartorderadapter = ArrayAdapter.createFromResource(this,
                R.array.Chartorder, android.R.layout.simple_spinner_item);
        txtorderadapter = ArrayAdapter.createFromResource(this,
                R.array.Txtoroder, android.R.layout.simple_spinner_item);
//endregion

        arraylocaldata.addAll(MainActivity.arraylocalData);
        arraylocaldata1.addAll(MainActivity.arraylocalData);
        AlllistRemove();

        spi_capital1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("CCTV")) {

                    Showgraph(1,"cctv");
                    Maxorder("cctv");
                    spi_txtopder.setSelection(0);
                    spi_chartorder.setSelection(0);
                } else if(adapterView.getItemAtPosition(i).equals("보안등")) {
                    Showgraph(1,"lamp");
                    Maxorder("lamp");
                    spi_txtopder.setSelection(0);
                    spi_chartorder.setSelection(0);
                } else if(adapterView.getItemAtPosition(i).equals("인구수")){
                    Showgraph(1,"population");
                    Maxorder("population");
                    spi_txtopder.setSelection(0);
                    spi_chartorder.setSelection(0);
                }else if(adapterView.getItemAtPosition(i).equals("발생건수")){
                    Showgraph(1,"crime");
                    Maxorder("crime");
                    spi_txtopder.setSelection(0);
                    spi_chartorder.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spi_capital1.setAdapter(chartadapter);

        spi_txtopder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("오름차순")) {
                    if (spi_capital1.getSelectedItem().toString().equals("CCTV")) {
                        Maxorder("cctv");
                    } else if (spi_capital1.getSelectedItem().toString().equals("보안등")) {
                        Maxorder("lamp");
                    } else if (spi_capital1.getSelectedItem().toString().equals("인구수")) {
                        Maxorder("population");
                    } else if (spi_capital1.getSelectedItem().toString().equals("발생건수")) {
                        Maxorder("crime");
                    }
                }

                if (adapterView.getItemAtPosition(i).toString().equals("내림차순")) {
                    if (spi_capital1.getSelectedItem().toString().equals("CCTV")) {
                        Minorder("cctv");
                    } else if (spi_capital1.getSelectedItem().toString().equals("보안등")) {
                        Minorder("lamp");
                    } else if (spi_capital1.getSelectedItem().toString().equals("인구수")) {
                        Minorder("population");
                    } else if (spi_capital1.getSelectedItem().toString().equals("발생건수")) {
                        Minorder("crime");
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spi_txtopder.setAdapter(txtorderadapter);

        spi_chartorder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("오름차순")) {
                    if (spi_capital1.getSelectedItem().toString().equals("CCTV")) {
                        Ascendingcctv ascendingcctv = new Ascendingcctv();
                        Collections.sort(arraylocaldata1,ascendingcctv);
                        Showgraph(2,"cctv");
                    } else if (spi_capital1.getSelectedItem().toString().equals("보안등")) {
                        Ascendinglamp ascendinglamp = new Ascendinglamp();
                        Collections.sort(arraylocaldata1,ascendinglamp);
                        Showgraph(2,"lamp");
                    } else if (spi_capital1.getSelectedItem().toString().equals("인구수")) {
                        Ascendingpopulation ascendingpopulation = new Ascendingpopulation();
                        Collections.sort(arraylocaldata1,ascendingpopulation);
                        Showgraph(2,"population");
                    } else if (spi_capital1.getSelectedItem().toString().equals("발생건수")) {
                        Ascendingcrime ascendingcrime = new Ascendingcrime();
                        Collections.sort(arraylocaldata1,ascendingcrime);
                        Showgraph(2,"crime");
                    }
                }

                if (adapterView.getItemAtPosition(i).toString().equals("내림차순")) {
                    if (spi_capital1.getSelectedItem().toString().equals("CCTV")) {
                        Descendingcctv descendingcctv = new Descendingcctv();
                        Collections.sort(arraylocaldata1,descendingcctv);
                        Showgraph(2,"cctv");
                    } else if (spi_capital1.getSelectedItem().toString().equals("보안등")) {
                        Descendinglamp descendinglamp = new Descendinglamp();
                        Collections.sort(arraylocaldata1,descendinglamp);
                        Showgraph(2,"lamp");
                    } else if (spi_capital1.getSelectedItem().toString().equals("인구수")) {
                        Descendingpopulation descendingpopulation = new Descendingpopulation();
                        Collections.sort(arraylocaldata1,descendingpopulation);
                        Showgraph(2,"population");
                    } else if (spi_capital1.getSelectedItem().toString().equals("발생건수")) {
                        Descendingcrime descendingcrime = new Descendingcrime();
                        Collections.sort(arraylocaldata1,descendingcrime);
                        Showgraph(2,"crime");
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spi_chartorder.setAdapter(chartorderadapter);



        BarEntryLabels = new ArrayList<String>();

        AddValuesToBarEntryLabels();

    }

    public void Showgraph(int value, String type){

        BARENTRY = new ArrayList<>();
        AddValuesToBARENTRY(value, type);

        Bardataset = new BarDataSet(BARENTRY, "Projects");
        BARDATA = new BarData(BarEntryLabels, Bardataset);


        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(2000);
    }

    long lg1 = 0;
    long lg2 = 0;
    public void AddValuesToBARENTRY(int value, String type){
        if(value == 1){
            if(type == "cctv"){
                for(int i=0;i<arraylocaldata.size();i++){
                    BARENTRY.add(new BarEntry(arraylocaldata.get(i).getCctvData(), i));
                }
            } else if(type == "lamp"){
                for(int i=0;i<arraylocaldata.size();i++){
                    BARENTRY.add(new BarEntry(arraylocaldata.get(i).getLampData(), i));
                }
            }else if(type == "population"){
                for(int i=0;i<arraylocaldata.size();i++){
                    BARENTRY.add(new BarEntry(arraylocaldata.get(i).getPopulationData(), i));
                }
            }else if(type == "crime"){
                for(int i=0;i<arraylocaldata.size();i++){
                    double doublecrime = arraylocaldata.get(i).getCrimeData();
                    lg1 = Math.round(doublecrime);
                    BARENTRY.add(new BarEntry(lg1, i));
                }
            }
        } else if (value == 2){
            if(type == "cctv"){
                for(int i=0;i<arraylocaldata1.size();i++){
                    BARENTRY.add(new BarEntry(arraylocaldata1.get(i).getCctvData(), i));
                }
            } else if(type == "lamp"){
                for(int i=0;i<arraylocaldata1.size();i++){
                    BARENTRY.add(new BarEntry(arraylocaldata1.get(i).getLampData(), i));
                }
            }else if(type == "population"){
                for(int i=0;i<arraylocaldata1.size();i++){
                    BARENTRY.add(new BarEntry(arraylocaldata1.get(i).getPopulationData(), i));
                }
            }else if(type == "crime"){
                for(int i=0;i<arraylocaldata1.size();i++){
                    double doublecrime = arraylocaldata1.get(i).getCrimeData();
                    lg2 = Math.round(doublecrime);
                    BARENTRY.add(new BarEntry(lg2, i));
                }
            }
        }
    }

    public void AddValuesToBarEntryLabels(){
        for(int i=0;i<arraylocaldata.size();i++){
            BarEntryLabels.add(String.valueOf(arraylocaldata.get(i).getLocalData()));
        }
    }


    public void Maxorder(String type){

        if(type == "cctv"){
            Ascendingcctv ascendingcctv = new Ascendingcctv();
            Collections.sort(arraylocaldata1,ascendingcctv);

            txt_Maxorder.setText(null);

            for(int i=0;i<arraylocaldata1.size();i++){
                txt_Maxorder.append((i+1)+". "+arraylocaldata1.get(i).getCapitalData()+" "+
                        arraylocaldata1.get(i).getLocalData()+": "+arraylocaldata1.get(i).getCctvData() +" \n ");
            }
        } else if(type == "lamp"){
            Ascendinglamp ascendinglamp = new Ascendinglamp();
            Collections.sort(arraylocaldata1,ascendinglamp);

            txt_Maxorder.setText(null);

            for(int i=0;i<arraylocaldata1.size();i++){
                txt_Maxorder.append((i+1)+". "+arraylocaldata1.get(i).getCapitalData()+" "+
                        arraylocaldata1.get(i).getLocalData()+": "+arraylocaldata1.get(i).getLampData() +" \n ");
            }

        }else if(type == "population"){
            Ascendingpopulation ascendingpopulation = new Ascendingpopulation();
            Collections.sort(arraylocaldata1,ascendingpopulation);

            txt_Maxorder.setText(null);

            for(int i=0;i<arraylocaldata1.size();i++) {
                txt_Maxorder.append((i + 1) + ". " + arraylocaldata1.get(i).getCapitalData()+" "+
                        arraylocaldata1.get(i).getLocalData() + ": " + arraylocaldata1.get(i).getPopulationData() + " \n ");
            }

        } else if(type == "crime"){
            Ascendingcrime ascendingcrime = new Ascendingcrime();
            Collections.sort(arraylocaldata1,ascendingcrime);

            txt_Maxorder.setText(null);


            for(int i=0;i<arraylocaldata1.size();i++) {
                txt_Maxorder.append((i + 1) + ". " + arraylocaldata1.get(i).getCapitalData()+" "+
                        arraylocaldata1.get(i).getLocalData() + ": " + arraylocaldata1.get(i).getCrimeData() + " \n ");
            }
        }


    }

    public void Minorder(String type){
        if(type == "cctv"){
            Descendingcctv descendingcctv = new Descendingcctv();
            Collections.sort(arraylocaldata1,descendingcctv);

            txt_Maxorder.setText(null);


            for(int i=0;i<arraylocaldata1.size();i++){
                txt_Maxorder.append((i+1)+". "+arraylocaldata1.get(i).getCapitalData()+"_"+
                        arraylocaldata1.get(i).getLocalData()+": "+arraylocaldata1.get(i).getCctvData() +" \n ");
            }
        } else if(type == "lamp"){
            Descendinglamp descendinglamp = new Descendinglamp();
            Collections.sort(arraylocaldata1,descendinglamp);

            txt_Maxorder.setText(null);

            for(int i=0;i<arraylocaldata1.size();i++){
                txt_Maxorder.append((i+1)+". "+arraylocaldata1.get(i).getCapitalData()+"_"+
                        arraylocaldata1.get(i).getLocalData()+": "+arraylocaldata1.get(i).getLampData() +" \n ");
            }

        }else if(type == "population"){
            Descendingpopulation descendingpopulation = new Descendingpopulation();
            Collections.sort(arraylocaldata1,descendingpopulation);

            txt_Maxorder.setText(null);

            for(int i=0;i<arraylocaldata1.size();i++) {
                txt_Maxorder.append((i+1)+". "+arraylocaldata1.get(i).getCapitalData()+"_"+
                        arraylocaldata1.get(i).getLocalData() + ": " + arraylocaldata1.get(i).getPopulationData() + " \n ");
            }

        } else if(type == "crime"){
            Descendingcrime descendingcrime = new Descendingcrime();
            Collections.sort(arraylocaldata1,descendingcrime);

            txt_Maxorder.setText(null);

            for(int i=0;i<arraylocaldata1.size();i++) {
                txt_Maxorder.append((i+1)+". "+arraylocaldata1.get(i).getCapitalData()+"_"+
                        arraylocaldata1.get(i).getLocalData() + ": " + arraylocaldata1.get(i).getCrimeData() + " \n ");
            }
        }
    }

    public void AlllistRemove() {
        try {
            for (int i = 0; i < arraylocaldata.size(); i++) {
                if (arraylocaldata.get(i).getLocalData().equals("전체")) {
                    arraylocaldata.remove(arraylocaldata.get(i));
                    arraylocaldata1.remove(arraylocaldata1.get(i));
                    i--;
                }
            }
        }catch(Exception e){
        }
    }

}

//내림차순
class Descendingcctv implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o1.getCctvData().compareTo(o2.getCctvData());
    }

}
class Descendinglamp implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o1.getLampData().compareTo(o2.getLampData());
    }

}
class Descendingpopulation implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o1.getPopulationData().compareTo(o2.getPopulationData());
    }

}
class Descendingcrime implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o1.getCrimeData().compareTo(o2.getCrimeData());
    }

}

// Integer 오름차순
class Ascendingcctv implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o2.getCctvData().compareTo(o1.getCctvData());
    }
}
class Ascendinglamp implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o2.getLampData().compareTo(o1.getLampData());
    }
}
class Ascendingpopulation implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o2.getPopulationData().compareTo(o1.getPopulationData());
    }
}
class Ascendingcrime implements Comparator<ArraylocalData> {

    @Override
    public int compare(ArraylocalData o1, ArraylocalData o2) {
        return o2.getCrimeData().compareTo(o1.getCrimeData());
    }
}