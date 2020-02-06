package com.example.jgh.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jgh.myapplication.Model.ArraylocalData;
import com.example.jgh.myapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graph3 extends AppCompatActivity{

    private TextView cctv1;
    private TextView lamp1;
    private TextView population1;
    private TextView crime1;
    private TextView local1;
    private TextView local2;
    private TextView cctv2;
    private TextView lamp2;
    private TextView population2;
    private TextView crime2;

    BarChart chart ;
    BarChart chart2 ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    ArrayList<BarEntry> BARENTRY2 ;
    BarDataSet Bardataset2 ;
    BarData BARDATA2 ;

    int compare1index = 0;
    int compare2index = 0;

    private ArrayList<ArraylocalData> arraylocalData;
    private MainActivity mainActivity = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph3);

        arraylocalData = new ArrayList<ArraylocalData>();

        // 화면구성
        cctv1 = (TextView) findViewById(R.id.cctv1);
        lamp1 = (TextView) findViewById(R.id.lamp1);
        population1 = (TextView) findViewById(R.id.population1);
        crime1 = (TextView) findViewById(R.id.crime1);
        cctv2 = (TextView) findViewById(R.id.cctv2);
        lamp2 = (TextView) findViewById(R.id.lamp2);
        population2 = (TextView) findViewById(R.id.population2);
        crime2 = (TextView) findViewById(R.id.crime2);
        local1 = (TextView) findViewById(R.id.local3);
        local2 = (TextView) findViewById(R.id.local4);
        chart = (BarChart) findViewById(R.id.chart1);
        chart2 = (BarChart) findViewById(R.id.chart2);
        final Spinner spi_capital1 = (Spinner) findViewById(R.id.sin_capital1);
        final Spinner spi_local1 = (Spinner) findViewById(R.id.sin_local1);
        final Spinner spi_capital2 = (Spinner) findViewById(R.id.sin_capital2);
        final Spinner spi_local2 = (Spinner) findViewById(R.id.sin_local2);

        //region 스피너 아이템처리
        final ArrayAdapter<CharSequence> capitaladapter = ArrayAdapter.createFromResource(this,
                R.array.Capital, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> busanadapter = ArrayAdapter.createFromResource(this,
                R.array.Busan, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> chungbukadapter = ArrayAdapter.createFromResource(this,
                R.array.Chungbuk, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> chungnamadapter = ArrayAdapter.createFromResource(this,
                R.array.Chungnam, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> daeguadapter = ArrayAdapter.createFromResource(this,
                R.array.Daegu, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> daejeonadapter = ArrayAdapter.createFromResource(this,
                R.array.Daejeon, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gangwonadapter = ArrayAdapter.createFromResource(this,
                R.array.Gangwon, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gwangjuadapter = ArrayAdapter.createFromResource(this,
                R.array.Gwangju, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gyungbukadapter = ArrayAdapter.createFromResource(this,
                R.array.Gyungbuk, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gyunggiadapter = ArrayAdapter.createFromResource(this,
                R.array.Gyunggi, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> cgyungnamadapter = ArrayAdapter.createFromResource(this,
                R.array.Gyungnam, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> inchunadapter = ArrayAdapter.createFromResource(this,
                R.array.Inchun, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> jejuadapter = ArrayAdapter.createFromResource(this,
                R.array.Jeju, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> jeonbukadapter = ArrayAdapter.createFromResource(this,
                R.array.Jeonbuk, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> jeonnamadapter = ArrayAdapter.createFromResource(this,
                R.array.Jeonnam, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> seouladapter = ArrayAdapter.createFromResource(this,
                R.array.Seoul, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ulsanadapter = ArrayAdapter.createFromResource(this,
                R.array.Ulsan, android.R.layout.simple_spinner_item);
        //endregion

        //region 스피너1 capital
        spi_capital1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getItemAtPosition(position).equals("부산광역시")) {
                    spi_local1.setAdapter(busanadapter);
                } else if(parent.getItemAtPosition(position).equals("충청북도")){
                    spi_local1.setAdapter(chungbukadapter);
                } else if(parent.getItemAtPosition(position).equals("충청남도")){
                    spi_local1.setAdapter(chungnamadapter);
                } else if(parent.getItemAtPosition(position).equals("대구광역시")){
                    spi_local1.setAdapter(daeguadapter);
                } else if(parent.getItemAtPosition(position).equals("대전광역시")){
                    spi_local1.setAdapter(daejeonadapter);
                } else if(parent.getItemAtPosition(position).equals("강원도")){
                    spi_local1.setAdapter(gangwonadapter);
                } else if(parent.getItemAtPosition(position).equals("광주광역시")){
                    spi_local1.setAdapter(gwangjuadapter);
                } else if(parent.getItemAtPosition(position).equals("경상북도")){
                    spi_local1.setAdapter(gyungbukadapter);
                } else if(parent.getItemAtPosition(position).equals("경기도")){
                    spi_local1.setAdapter(gyunggiadapter);
                } else if(parent.getItemAtPosition(position).equals("경상남도")){
                    spi_local1.setAdapter(cgyungnamadapter);
                } else if(parent.getItemAtPosition(position).equals("인천광역시")){
                    spi_local1.setAdapter(inchunadapter);
                } else if(parent.getItemAtPosition(position).equals("제주특별자치도")){
                    spi_local1.setAdapter(jejuadapter);
                } else if(parent.getItemAtPosition(position).equals("전라북도")){
                    spi_local1.setAdapter(jeonbukadapter);
                } else if(parent.getItemAtPosition(position).equals("전라남도")){
                    spi_local1.setAdapter(jeonnamadapter);
                } else if(parent.getItemAtPosition(position).equals("서울특별시")){
                    spi_local1.setAdapter(seouladapter);
                } else if(parent.getItemAtPosition(position).equals("울산광역시")){
                    spi_local1.setAdapter(ulsanadapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //endregion
        spi_capital1.setAdapter(capitaladapter);

        //region 스피너1 local

        spi_local1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                for(int i = 0;i<mainActivity.arraylocalData.size();i++){
                    if(spi_capital1.getSelectedItem().toString().equals(mainActivity.arraylocalData.get(i).getCapitalData())&&
                            adapterView.getItemAtPosition(position).equals(mainActivity.arraylocalData.get(i).getLocalData())){
                        compare1index = i;
                        break;
                    }

                }SaveData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//endregion

        //region 스피너2 capital
        spi_capital2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getItemAtPosition(position).equals("부산광역시")) {
                    spi_local2.setAdapter(busanadapter);
                } else if(parent.getItemAtPosition(position).equals("충청북도")){
                    spi_local2.setAdapter(chungbukadapter);
                } else if(parent.getItemAtPosition(position).equals("충청남도")){
                    spi_local2.setAdapter(chungnamadapter);
                } else if(parent.getItemAtPosition(position).equals("대구광역시")){
                    spi_local2.setAdapter(daeguadapter);
                } else if(parent.getItemAtPosition(position).equals("대전광역시")){
                    spi_local2.setAdapter(daejeonadapter);
                } else if(parent.getItemAtPosition(position).equals("강원도")){
                    spi_local2.setAdapter(gangwonadapter);
                } else if(parent.getItemAtPosition(position).equals("광주광역시")){
                    spi_local2.setAdapter(gwangjuadapter);
                } else if(parent.getItemAtPosition(position).equals("경상북도")){
                    spi_local2.setAdapter(gyungbukadapter);
                } else if(parent.getItemAtPosition(position).equals("경기도")){
                    spi_local2.setAdapter(gyunggiadapter);
                } else if(parent.getItemAtPosition(position).equals("경상남도")){
                    spi_local2.setAdapter(cgyungnamadapter);
                } else if(parent.getItemAtPosition(position).equals("인천광역시")){
                    spi_local2.setAdapter(inchunadapter);
                } else if(parent.getItemAtPosition(position).equals("제주특별자치도")){
                    spi_local2.setAdapter(jejuadapter);
                } else if(parent.getItemAtPosition(position).equals("전라북도")){
                    spi_local2.setAdapter(jeonbukadapter);
                } else if(parent.getItemAtPosition(position).equals("전라남도")){
                    spi_local2.setAdapter(jeonnamadapter);
                } else if(parent.getItemAtPosition(position).equals("서울특별시")){
                    spi_local2.setAdapter(seouladapter);
                } else if(parent.getItemAtPosition(position).equals("울산광역시")){
                    spi_local2.setAdapter(ulsanadapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        //endregion


        //region 스피터2 local
        spi_local2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                for(int i = 0;i<mainActivity.arraylocalData.size();i++){
                    if(spi_capital2.getSelectedItem().toString().equals(mainActivity.arraylocalData.get(i).getCapitalData())&&
                            adapterView.getItemAtPosition(position).equals(mainActivity.arraylocalData.get(i).getLocalData())){
                        compare2index = i;

                        break;
                    }

                }SaveData2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //endregion

        spi_capital2.setAdapter(capitaladapter);
        arraylocalData.addAll(mainActivity.arraylocalData);

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBarEntryLabels();


    }

    public void Showgraph(){
        AddValuesToBARENTRY(arraylocalData.get(compare1index).getCctvData(),
                arraylocalData.get(compare1index).getLampData(),
                arraylocalData.get(compare1index).getPopulationData(),
                arraylocalData.get(compare1index).getCrimeData());

        Bardataset = new BarDataSet(BARENTRY, "Projects");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);


        YAxis left = chart.getAxisLeft();
        YAxis right = chart.getAxisRight();
        left.setEnabled(false);
        right.setEnabled(false);

        chart.setDrawBarShadow(true);
        chart.setData(BARDATA);

        chart.animateY(3000);
    }
    public void Showgraph2(){
        AddValuesToBARENTRY2(arraylocalData.get(compare2index).getCctvData(),
                arraylocalData.get(compare2index).getLampData(),
                arraylocalData.get(compare2index).getPopulationData(),
                arraylocalData.get(compare2index).getCrimeData());

        Bardataset2 = new BarDataSet(BARENTRY2, "Projects");

        BARDATA2 = new BarData(BarEntryLabels, Bardataset2);

        Bardataset2.setColors(ColorTemplate.COLORFUL_COLORS);

        YAxis left = chart2.getAxisLeft();
        YAxis right = chart2.getAxisRight();
        left.setEnabled(false);
        right.setEnabled(false);

        chart2.setDrawBarShadow(true);
        chart2.setData(BARDATA2);

        chart2.animateY(3000);
    }
    public void AddValuesToBARENTRY(int cctv,int lamp, int population, double crime){

        BARENTRY = new ArrayList<>();
        BARENTRY.add(new BarEntry(cctv, 0));
        BARENTRY.add(new BarEntry(lamp, 1));
        BARENTRY.add(new BarEntry(population, 2));
        BARENTRY.add(new BarEntry((int)crime, 3));

    }
    public void AddValuesToBARENTRY2(int cctv,int lamp, int population, double crime){

        BARENTRY2 = new ArrayList<>();
        BARENTRY2.add(new BarEntry(cctv, 0));
        BARENTRY2.add(new BarEntry(lamp, 1));
        BARENTRY2.add(new BarEntry(population, 2));
        BARENTRY2.add(new BarEntry((int)crime, 3));

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("CCTV");
        BarEntryLabels.add("보안등");
        BarEntryLabels.add("인구수");
        BarEntryLabels.add("발생건수");

    }
    public void SaveData(){


        cctv1.setText(""+mainActivity.arraylocalData.get(compare1index).getCctvData());
        lamp1.setText(""+mainActivity.arraylocalData.get(compare1index).getLampData());
        population1.setText(""+mainActivity.arraylocalData.get(compare1index).getPopulationData());
        crime1.setText(""+mainActivity.arraylocalData.get(compare1index).getCrimeData());
        local1.setText(""+mainActivity.arraylocalData.get(compare1index).getLocalData());
        Showgraph();
    }

    public void SaveData2(){
        cctv2.setText(""+mainActivity.arraylocalData.get(compare2index).getCctvData());
        lamp2.setText(""+mainActivity.arraylocalData.get(compare2index).getLampData());
        population2.setText(""+mainActivity.arraylocalData.get(compare2index).getPopulationData());
        crime2.setText(""+mainActivity.arraylocalData.get(compare2index).getCrimeData());
        local2.setText(""+mainActivity.arraylocalData.get(compare2index).getLocalData());

        Showgraph2();
    }
}

