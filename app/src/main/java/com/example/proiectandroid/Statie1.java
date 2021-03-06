package com.example.proiectandroid;

import java.util.Arrays;

public class Statie1
{
    private int id_statie;
    private int id_linie;
    private String nume;
    private String[] vecini;

    public Statie1(int id_statie, int id_linie, String nume, String vecini) {
        this.id_statie = id_statie;
        this.id_linie = id_linie;
        this.nume = nume;
        if(vecini!= null)
        {
            this.vecini = vecini.split(",", 15);
        }
    }

    public int getId_statie() {
        return id_statie;
    }

    public void setId_statie(int id_statie) {
        this.id_statie = id_statie;
    }

    public int getId_linie() {
        return id_linie;
    }

    public void setId_linie(int id_linie) {
        this.id_linie = id_linie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String[] getVecini() {
        return vecini;
    }

    public void setVecini(String[] vecini) {
        this.vecini = vecini;
    }

    public Statie1()
    {}


    @Override
    public String toString() {
        return "Statie{" +
                "id_statie=" + id_statie +
                ", id_linie=" + id_linie +
                ", nume='" + nume + '\'' +
                ", vecini=" + Arrays.toString(vecini) +
                '}';
    }
}
