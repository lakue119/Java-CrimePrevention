package com.example.jgh.myapplication.Model;

import java.io.Serializable;

/**
 * Created by audfk on 2018-01-16.
 */

class MarkData implements Serializable{
    private String X;
    private String Y;

    public String getX(){
        return X;
    }
    public void setX(String x){
        this.X = x;
    }

    public String getY(){
        return Y;
    }
    public void setY(String y){
        this.Y = y;
    }

    public String toString(){
        return X + "," + Y;
    }
}