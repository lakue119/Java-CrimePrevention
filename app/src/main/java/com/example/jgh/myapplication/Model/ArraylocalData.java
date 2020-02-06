package com.example.jgh.myapplication.Model;

/**
 * Created by JGH on 2018-02-07.
 */

public class ArraylocalData {

    private Integer CctvData;
    private Integer LampData;
    private Integer PopulationData;
    private Double AreaData;
    private Double CrimeData;
    private String LocalData;
    private String CapitalData;
    private Double ForEachCctvData;
    private Double ForEachLampData;

    public Integer getCctvData(){
        return CctvData;
    }
    public void setCctvData(Integer cctvdata){
        this.CctvData = cctvdata;
    }

    public Integer getLampData(){
        return LampData;
    }
    public void setLampData(Integer lampdata){
        this.LampData = lampdata;
    }

    public Integer getPopulationData(){
        return PopulationData;
    }
    public void setPopulationData(Integer populationdata){
        this.PopulationData = populationdata;
    }

    public Double getCrimeData(){
        return CrimeData;
    }
    public void setCrimeData(Double crimedata){
        this.CrimeData = crimedata;
    }

    public String getLocalData(){
        return LocalData;
    }
    public void setLocalData(String lacaldata){
        this.LocalData = lacaldata;
    }

    public Double getAreaData() {
        return AreaData;
    }
    public void setAreaData(Double areaData) {
        AreaData = areaData;
    }

    public String getCapitalData() {
        return CapitalData;
    }
    public void setCapitalData(String capitalData) {
        CapitalData = capitalData;
    }

    public Double getForEachCctvData() {
        return ForEachCctvData;
    }
    public void setForEachCctvData(Double forEachCctvData) {
        ForEachCctvData = forEachCctvData;
    }

    public Double getForEachLampData() {
        return ForEachLampData;
    }
    public void setForEachLampData(Double forEachLampData) {
        ForEachLampData = forEachLampData;
    }

    @Override
    public String toString() {
        return CctvData+",  "+ LampData + ",  " + PopulationData +",  "+ CrimeData+",  "+ AreaData + ",  "
                + ForEachCctvData + ",  " +ForEachLampData +"\n"+ CapitalData +",  "+ LocalData;
    }



}