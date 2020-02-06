package com.example.jgh.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jgh.myapplication.Model.ArraylocalData;
import com.example.jgh.myapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DataAnalysisGraph extends AppCompatActivity {

    public static ArrayList<ArraylocalData> arraylocaldata;

    private MainActivity mainActivity = new MainActivity();


    int compareidx=0;
    int firstidx;
    int middleidx;
    int lastidx;

    TextView txt_compare;
    TextView txt_standard1;
    TextView txt_standard2;
    TextView txt_standard3;

    //region 차트 선언
    BarChart chart_compare1 ;
    ArrayList<BarEntry> BARENTRY1 ;
    ArrayList<String> BarEntryLabels1 ;
    BarDataSet Bardataset1 ;
    BarData BARDATA1 ;


    BarChart chart_standard1 ;
    ArrayList<BarEntry> BARENTRY3 ;
    BarDataSet Bardataset3 ;
    BarData BARDATA3 ;

    BarChart chart_standard2 ;
    ArrayList<BarEntry> BARENTRY4 ;
    BarDataSet Bardataset4 ;
    BarData BARDATA4 ;

    BarChart chart_standard3 ;
    ArrayList<BarEntry> BARENTRY5 ;
    BarDataSet Bardataset5 ;
    BarData BARDATA5 ;

    //endregion
    private String capital="";
    private String local="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_analysis_graph);

        arraylocaldata= new ArrayList<ArraylocalData>();
        arraylocaldata.addAll(mainActivity.solution_arraylocalData);

        final Spinner spi_capital = (Spinner) findViewById(R.id.sin_capital);
        final Spinner spi_local = (Spinner) findViewById(R.id.sin_local);

        //region 스피너 아뎁터
        final ArrayAdapter<CharSequence> capitaladapter = ArrayAdapter.createFromResource(this,
                R.array.Capital, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> busanadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataBusan, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> chungbukadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataChungbuk, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> chungnamadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataChungnam, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> daeguadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataDaegu, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> daejeonadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataDaejeon, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gangwonadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataGangwon, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gwangjuadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataGwangju, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gyungbukadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataGyungbuk, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> gyunggiadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataGyunggi, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> cgyungnamadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataGyungnam, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> inchunadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataInchun, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> jejuadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataJeju, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> jeonbukadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataJeonbuk, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> jeonnamadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataJeonnam, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> seouladapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataSeoul, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ulsanadapter = ArrayAdapter.createFromResource(this,
                R.array.AlldataUlsan, android.R.layout.simple_spinner_item);
        //endregion

        spi_capital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if (parent.getItemAtPosition(position).equals("부산광역시")) {
                    spi_local.setAdapter(busanadapter);
                } else if(parent.getItemAtPosition(position).equals("충청북도")){
                    spi_local.setAdapter(chungbukadapter);
                } else if(parent.getItemAtPosition(position).equals("충청남도")){
                    spi_local.setAdapter(chungnamadapter);
                } else if(parent.getItemAtPosition(position).equals("대구광역시")){
                    spi_local.setAdapter(daeguadapter);
                } else if(parent.getItemAtPosition(position).equals("대전광역시")){
                    spi_local.setAdapter(daejeonadapter);
                } else if(parent.getItemAtPosition(position).equals("강원도")){
                    spi_local.setAdapter(gangwonadapter);
                } else if(parent.getItemAtPosition(position).equals("광주광역시")){
                    spi_local.setAdapter(gwangjuadapter);
                } else if(parent.getItemAtPosition(position).equals("경상북도")){
                    spi_local.setAdapter(gyungbukadapter);
                } else if(parent.getItemAtPosition(position).equals("경기도")){
                    spi_local.setAdapter(gyunggiadapter);
                } else if(parent.getItemAtPosition(position).equals("경상남도")){
                    spi_local.setAdapter(cgyungnamadapter);
                } else if(parent.getItemAtPosition(position).equals("인천광역시")){
                    spi_local.setAdapter(inchunadapter);
                } else if(parent.getItemAtPosition(position).equals("제주특별자치도")){
                    spi_local.setAdapter(jejuadapter);
                } else if(parent.getItemAtPosition(position).equals("전라북도")){
                    spi_local.setAdapter(jeonbukadapter);
                } else if(parent.getItemAtPosition(position).equals("전라남도")){
                    spi_local.setAdapter(jeonnamadapter);
                } else if(parent.getItemAtPosition(position).equals("서울특별시")){
                    spi_local.setAdapter(seouladapter);
                } else if(parent.getItemAtPosition(position).equals("울산광역시")){
                    spi_local.setAdapter(ulsanadapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spi_capital.setAdapter(capitaladapter);

        spi_local.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                compareidx = 0;

                for(int i=0;i<arraylocaldata.size();++i) {
                    if (spi_capital.getSelectedItem().toString().equals(arraylocaldata.get(i).getCapitalData()) &&
                            parent.getItemAtPosition(position).equals(arraylocaldata.get(i).getLocalData())) {

                        compareidx = i;

                        Showgraph1();
                        //Showgraph2();
                        Showgraph3();
                        Showgraph4();
                        Showgraph5();
                        ShowText(spi_capital.getSelectedItem().toString(),parent.getItemAtPosition(position).toString());
                        CompareShowText(middleidx,txt_standard1);
                        CompareShowText(lastidx,txt_standard2);
                        CompareShowText(arraylocaldata.size()-1,txt_standard3);
                        break;
                    } else{}
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        chart_compare1 = (BarChart) findViewById(R.id.chart_compare);
        //chart_compare2 = (BarChart) findViewById(R.id.chart_compare2);
        chart_standard1 = (BarChart) findViewById(R.id.chart_standard1);
        chart_standard2 = (BarChart) findViewById(R.id.chart_standard2);
        chart_standard3 = (BarChart) findViewById(R.id.chart_standard3);


        txt_compare = (TextView) findViewById(R.id.txt_compare);
        txt_compare.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();

        txt_standard1 = (TextView) findViewById(R.id.txt_standard1);
        txt_standard1.setMovementMethod(new ScrollingMovementMethod());

        txt_standard2 = (TextView) findViewById(R.id.txt_standard2);
        txt_standard2.setMovementMethod(new ScrollingMovementMethod());

        txt_standard3 = (TextView) findViewById(R.id.txt_standard3);
        txt_standard3.setMovementMethod(new ScrollingMovementMethod());

        capital = intent.getStringExtra("MapCapital");
        local = intent.getStringExtra("MapLocal");

        //region 차트데이터
        BarEntryLabels1 = new ArrayList<String>();
        AddValuesToBarEntryLabels();
        //endregion
        ForEachCctvLamp();

        int count1=0;
        if(capital!=null && local !=null && count1 == 0){
            MapIntentSaveData();
            Showgraph1();

            MapShowText();

            Showgraph3();
            Showgraph4();
            Showgraph5();
            CompareShowText(middleidx,txt_standard1);
            CompareShowText(lastidx,txt_standard2);
            CompareShowText(arraylocaldata.size()-1,txt_standard3);
            count++;
        }



    }

    public void Showgraph1(){

        BARENTRY1 = new ArrayList<>();
        AddValuesToBARENTRY1();

        Bardataset1 = new BarDataSet(BARENTRY1, "보안장치 데이터");
        BARDATA1 = new BarData(BarEntryLabels1, Bardataset1);

        Bardataset1.setColors(ColorTemplate.COLORFUL_COLORS);

        chart_compare1.setDrawBarShadow(true);
        chart_compare1.setData(BARDATA1);
        chart_compare1.animateY(2000);
    }
    int count = 0;
    public void AddValuesToBARENTRY1(){
        if(capital != null && local != null && count == 0){
            MapIntentSaveData();
            compareidx = mapintentindex;

            BARENTRY1.add(new BarEntry(arraylocaldata.get(compareidx).getCctvData(), 0));
            BARENTRY1.add(new BarEntry(arraylocaldata.get(compareidx).getLampData(), 1));
            count++;

        } else {
            BARENTRY1.add(new BarEntry(arraylocaldata.get(compareidx).getCctvData(), 0));
            BARENTRY1.add(new BarEntry(arraylocaldata.get(compareidx).getLampData(), 1));
        }
    }
    public void AddValuesToBarEntryLabels(){

        BarEntryLabels1.add("CCTV");
        BarEntryLabels1.add("보안등");

    }


    public void Showgraph3(){

        BARENTRY3 = new ArrayList<>();
        AddValuesToBARENTRY3();

        Bardataset3 = new BarDataSet(BARENTRY3, "1차 보안장치 데이터");
        BARDATA3 = new BarData(BarEntryLabels1, Bardataset3);

        Bardataset3.setColors(ColorTemplate.COLORFUL_COLORS);

        chart_standard1.setDrawBarShadow(true);
        chart_standard1.setData(BARDATA3);
        chart_standard1.animateY(2000);
    }
    public void AddValuesToBARENTRY3(){
        firstidx = (int)((arraylocaldata.size()-compareidx)/3);
        middleidx = compareidx + firstidx;

        BARENTRY3.add(new BarEntry(arraylocaldata.get(middleidx).getCctvData(), 0));
        BARENTRY3.add(new BarEntry(arraylocaldata.get(middleidx).getLampData(), 1));
    }

    public void Showgraph4(){

        BARENTRY4 = new ArrayList<>();
        AddValuesToBARENTRY4();

        Bardataset4 = new BarDataSet(BARENTRY4, "2차 보안장치 데이터");
        BARDATA4 = new BarData(BarEntryLabels1, Bardataset4);

        Bardataset4.setColors(ColorTemplate.COLORFUL_COLORS);

        chart_standard2.setDrawBarShadow(true);
        chart_standard2.setData(BARDATA4);
        chart_standard2.animateY(2000);
    }
    public void AddValuesToBARENTRY4(){

        firstidx = (arraylocaldata.size()-compareidx)/3;
        lastidx = middleidx + firstidx;

        BARENTRY4.add(new BarEntry(arraylocaldata.get(lastidx).getCctvData(), 0));
        BARENTRY4.add(new BarEntry(arraylocaldata.get(lastidx).getLampData(), 1));

    }

    public void Showgraph5(){

        BARENTRY5 = new ArrayList<>();
        AddValuesToBARENTRY5();

        Bardataset5 = new BarDataSet(BARENTRY5, "최적화도시 보안장치 데이터");
        BARDATA5 = new BarData(BarEntryLabels1, Bardataset5);

        Bardataset5.setColors(ColorTemplate.COLORFUL_COLORS);

        chart_standard3.setDrawBarShadow(true);
        chart_standard3.setData(BARDATA5);
        chart_standard3.animateY(2000);
    }
    public void AddValuesToBARENTRY5(){

        BARENTRY5.add(new BarEntry(arraylocaldata.get(arraylocaldata.size()-1).getCctvData(), 0));
        BARENTRY5.add(new BarEntry(arraylocaldata.get(arraylocaldata.size()-1).getLampData(), 1));

    }

    public void ShowText(String capital, String local){
        txt_compare.setText(null);

        for(int i=0;i<arraylocaldata.size();i++){
            double comparecctvdata = arraylocaldata.get(i).getCctvData();
            double comparelampdata = arraylocaldata.get(i).getLampData();

            if(arraylocaldata.get(i).getCapitalData().equals(capital) && arraylocaldata.get(i).getLocalData().equals(local)){
                txt_compare.append("지역 : " + capital + "\n도시 : " + local + "\nCCTV개수 : " +
                        comparecctvdata + "\n보안등 개수 : " + comparelampdata + "\n범죄 건수 : " + arraylocaldata.get(i).getCrimeData()
                );
                break;
            }

        }

    }

    public void CompareShowText(int standard, TextView text) {
        text.setText(null);

        double standardeachcctvdata = arraylocaldata.get(standard).getForEachCctvData();
        double standardeachlampdata = arraylocaldata.get(standard).getForEachLampData();
        double standardcrimedata = arraylocaldata.get(standard).getCrimeData();


        double compareeachcctvdata = arraylocaldata.get(compareidx).getForEachCctvData();
        double compareeachlampdata = arraylocaldata.get(compareidx).getForEachLampData();
        double comparecctvdata = arraylocaldata.get(standard).getCctvData();
        double comparelampdata = arraylocaldata.get(standard).getLampData();
        double comparepopulationdata = arraylocaldata.get(compareidx).getPopulationData();
        double domparecrimedata = arraylocaldata.get(compareidx).getCrimeData();


        if (standardeachcctvdata < compareeachcctvdata &&
                standardeachlampdata > compareeachlampdata) {
            text.append("지역 : " + arraylocaldata.get(standard).getCapitalData() + "\n도시 : " +
                    arraylocaldata.get(standard).getLocalData() + "\nCCTV개수 : " +
                    comparecctvdata + "\n보안등 개수 : " + comparelampdata +
                    "\n\nCCTV보다는 약 " +

                    (int) Math.round((arraylocaldata.get(standard).getForEachLampData() * arraylocaldata.get(compareidx).getPopulationData())-
                            arraylocaldata.get(compareidx).getLampData()) +

                    "개의 보안등이 더 필요합니다.\n\n약 " + (int) Math.round(domparecrimedata - standardcrimedata) +
                    "건 (" + (int)Math.round(((((domparecrimedata - standardcrimedata) / domparecrimedata) * 100)/3)) +
                    "%)의 범죄건수가 줄어들 것입니다.");
        } else if (standardeachcctvdata > compareeachcctvdata &&
                standardeachlampdata > compareeachlampdata) {
            text.append("지역 : " + arraylocaldata.get(standard).getCapitalData() + "\n도시 : " +
                    arraylocaldata.get(standard).getLocalData() + "\nCCTV개수 : " +
                    comparecctvdata + "\n보안등 개수 : " + comparelampdata +
                    "\n\n약 " +

                    (int) Math.round((arraylocaldata.get(standard).getForEachCctvData() * arraylocaldata.get(compareidx).getPopulationData())-
                            arraylocaldata.get(compareidx).getCctvData())


                    + "개의 CCTV가 더 필요하고, \n약 " +

                    (int) Math.round((arraylocaldata.get(standard).getForEachLampData() * arraylocaldata.get(compareidx).getPopulationData())-
                            arraylocaldata.get(compareidx).getLampData()) +

                    "개의 보안등이 더 필요합니다.\n\n약 " + (int) Math.round(domparecrimedata - standardcrimedata) +
                    "건(" + (int) Math.round(((((domparecrimedata - standardcrimedata) / domparecrimedata) * 100)/3)) +
                    "%)의 범죄건수가 줄어들 것입니다.");
        } else if (standardeachcctvdata > compareeachcctvdata &&
                standardeachlampdata < compareeachlampdata) {
            text.append("지역 : " + arraylocaldata.get(standard).getCapitalData() + "\n도시 : " +
                    arraylocaldata.get(standard).getLocalData() + "\nCCTV개수 : " +
                    comparecctvdata + "\n보안등 개수 : " + comparelampdata +
                    "\n\n보안등보다는 약 " +

                    (int) Math.round((arraylocaldata.get(standard).getForEachCctvData() * arraylocaldata.get(compareidx).getPopulationData())-
                            arraylocaldata.get(compareidx).getCctvData()) +

                    "개의 CCTV가 필요합니다. \n\n약 " + (int)Math.round( (domparecrimedata -
                    standardcrimedata)) +
                    "건(" + (int) Math.round(((((domparecrimedata - standardcrimedata) / domparecrimedata) * 100)/3)) +
                    "%)의 범죄건수가 줄어들 것입니다.");
        } else if (standardeachcctvdata == compareeachcctvdata &&
                standardeachlampdata == compareeachlampdata) {
            text.append("가장 최적화된 도시입니다.");
        } else if (standardeachcctvdata < compareeachcctvdata &&
                standardeachlampdata < compareeachlampdata) {
            for (int i = standard; i < arraylocaldata.size(); i++) {

                if (arraylocaldata.get(i).getForEachCctvData() < compareeachcctvdata &&
                        arraylocaldata.get(i).getForEachLampData() > compareeachlampdata) {
                    text.append("지역 : " + arraylocaldata.get(i).getCapitalData() + "\n도시 : " +
                            arraylocaldata.get(i).getLocalData() + "\nCCTV개수 : " +
                            comparecctvdata + "\n보안등 개수 : " + comparelampdata +
                            "\n\nCCTV보다는 약 " +


                            (int) Math.round((arraylocaldata.get(i).getForEachLampData() * arraylocaldata.get(compareidx).getPopulationData())-
                                    arraylocaldata.get(compareidx).getLampData())

                            +
                            "개의 보안등이 더 필요합니다.\n\n약 " +
                            (int) Math.round(arraylocaldata.get(compareidx).getCrimeData() - arraylocaldata.get(i).getCrimeData())
                            +
                            "건 (" + (int) Math.round(((((domparecrimedata - arraylocaldata.get(i).getCrimeData()) / domparecrimedata) * 100)/3)) +
                            "%)의 범죄건수가 줄어들 것입니다.");
                    break;
                } else if (arraylocaldata.get(i).getForEachCctvData() > compareeachcctvdata &&
                        arraylocaldata.get(i).getForEachLampData() > compareeachlampdata) {
                    text.append("지역 : " + arraylocaldata.get(i).getCapitalData() + "\n도시 : " +
                            arraylocaldata.get(i).getLocalData() + "\nCCTV개수 : " +
                            comparecctvdata + "\n보안등 개수 : " + comparelampdata +
                            "\n\n약 " +

                            (int) Math.round((arraylocaldata.get(i).getForEachCctvData() * arraylocaldata.get(compareidx).getPopulationData())-
                                    arraylocaldata.get(compareidx).getCctvData()) +

                            "개의 CCTV가 더 필요하고, \n약 " +


                            (int) Math.round((arraylocaldata.get(i).getForEachLampData() * arraylocaldata.get(compareidx).getPopulationData())-
                                    arraylocaldata.get(compareidx).getLampData())  +


                            "개의 보안등이 더 필요합니다.\n\n약 " +
                            (int) Math.round(arraylocaldata.get(compareidx).getCrimeData() - arraylocaldata.get(i).getCrimeData())
                            +
                            "건(" + (int)Math.round( (((domparecrimedata - arraylocaldata.get(i).getCrimeData()) / domparecrimedata) * 100)/3) +
                            "%)의 범죄건수가 줄어들 것입니다.");
                    break;
                } else if (arraylocaldata.get(i).getForEachCctvData() > compareeachcctvdata &&
                        arraylocaldata.get(i).getForEachLampData() < compareeachlampdata) {
                    text.append("지역 : " + arraylocaldata.get(i).getCapitalData() + "\n도시 : " +
                            arraylocaldata.get(i).getLocalData() + "\nCCTV개수 : " +
                            comparecctvdata + "\n보안등 개수 : " + comparelampdata +
                            "\n\n보안등보다는 약 " +

                            (int) Math.round((arraylocaldata.get(i).getForEachCctvData() * arraylocaldata.get(compareidx).getPopulationData())-
                                    arraylocaldata.get(compareidx).getCctvData()) +

                            "개의 CCTV가 필요합니다. \n\n약 " +
                            (int) Math.round(arraylocaldata.get(compareidx).getCrimeData() - arraylocaldata.get(i).getCrimeData())
                            +
                            "건(" + (int) Math.round(((((domparecrimedata - arraylocaldata.get(i).getCrimeData()) / domparecrimedata) * 100)/3)) +
                            "%)의 범죄건수가 줄어들 것입니다.");
                    break;
                } else if (arraylocaldata.get(i).getForEachCctvData() == compareeachcctvdata &&
                        arraylocaldata.get(i).getForEachLampData() == compareeachlampdata) {
                    text.append("가장 최적화된 도시입니다.");
                    break;
                }
            }

        } else {
        }


    }
    int mapintentindex = 0;
    public void MapIntentSaveData(){
        for(int i=0;i<arraylocaldata.size();i++){
            if(arraylocaldata.get(i).getCapitalData().equals(capital) && arraylocaldata.get(i).getLocalData().equals(local)){
                mapintentindex = i;
                break;
            }
        }
    }

    public void MapShowText() {

        double comparecctvdata = arraylocaldata.get(mapintentindex).getCctvData();
        double comparelampdata = arraylocaldata.get(mapintentindex).getLampData();

        txt_compare.append("지역 : " + capital + "\n도시 : " + local + "\nCCTV개수 : " +
                comparecctvdata + "\n보안등 개수 : " + comparelampdata+ "\n범죄 건수 : " + arraylocaldata.get(mapintentindex).getCrimeData() );

    }

    public void ForEachCctvLamp(){
        for(int i=0;i<arraylocaldata.size();i++){
            arraylocaldata.get(i).setForEachCctvData((double)arraylocaldata.get(i).getCctvData()/arraylocaldata.get(i).getPopulationData());
            arraylocaldata.get(i).setForEachLampData((double)arraylocaldata.get(i).getLampData()/arraylocaldata.get(i).getPopulationData());
        }
    }
}
