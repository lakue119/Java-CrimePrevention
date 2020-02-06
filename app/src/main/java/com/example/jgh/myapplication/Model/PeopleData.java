package com.example.jgh.myapplication.Model;

import java.io.Serializable;

/**
 * Created by audfk on 2018-01-22.
 */


public class PeopleData implements Serializable {
    private String Lacal;
    private String Population;

    public String getLacal() {
        return Lacal;
    }

    public void setLacal(String lacal) {
        this.Lacal = lacal;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        this.Population = population;
    }

    public String toString() {
        return Lacal + "," + Population;
    }
}