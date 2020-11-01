package com.example.proiectandroid;

public class Legaturi
{
    private int id_vecin1;
    private int id_vecin2;
    private int timp;

    public int getId_vecin1() {
        return id_vecin1;
    }

    public void setId_vecin1(int id_vecin1) {
        this.id_vecin1 = id_vecin1;
    }

    public int getId_vecin2() {
        return id_vecin2;
    }

    public void setId_vecin2(int id_vecin2) {
        this.id_vecin2 = id_vecin2;
    }

    public int getTimp() {
        return timp;
    }

    public void setTimp(int timp) {
        this.timp = timp;
    }

    public Legaturi(int id_vecin1, int id_vecin2, int timp) {
        this.id_vecin1 = id_vecin1;
        this.id_vecin2 = id_vecin2;
        this.timp = timp;
    }

    public Legaturi() {
    }

    @Override
    public String toString() {
        return "Legaturi{" +
                "id_vecin1=" + id_vecin1 +
                ", id_vecin2=" + id_vecin2 +
                ", timp=" + timp +
                '}';
    }
}
