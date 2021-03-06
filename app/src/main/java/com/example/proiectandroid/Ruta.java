package com.example.proiectandroid;

import java.util.ArrayList;

public class Ruta implements Comparable{
    private ArrayList<Statie1> statii;
    private int timp;

    public Ruta()
    {}

    public Ruta(ArrayList<Statie1> statii, int timp) {
        this.statii = statii;
        this.timp = timp;
    }

    public ArrayList<Statie1> getStatii() {
        return statii;
    }

    public void setStatii(ArrayList<Statie1> statii) {
        this.statii = statii;
    }

    public int getTimp() {
        return timp;
    }

    public void setTimp(int timp) {
        this.timp = timp;
    }

    @Override
    public int compareTo(Object ruta) {
        return this.timp-((Ruta)ruta).getTimp();
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "statii=" + statii +
                ", timp=" + timp +
                '}';
    }
}
