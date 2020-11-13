package com.example.proiectandroid;

public class TimpAsteptare
{
    private String interval_orar;
    private int timp;

    public TimpAsteptare(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }

    public TimpAsteptare() {
    }

    public String getInterval_orar() {
        return interval_orar;
    }

    public void setInterval_orar(String interval_orar) {
        this.interval_orar = interval_orar;
    }

    public int getTimp() {
        return timp;
    }

    public void setTimp(int timp) {
        this.timp = timp;
    }

    @Override
    public String toString() {
        return "TimpiAsteptare{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }
}
