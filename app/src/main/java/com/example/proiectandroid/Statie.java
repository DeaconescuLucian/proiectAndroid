package com.example.proiectandroid;

import java.util.Arrays;

public class Statie
{
    private int id_statie;
    private int id_linie;
    private String nume;
    private String[] vecini;

    public Statie(int id_statie, int id_linie, String nume, String[] vecini) {
        this.id_statie = id_statie;
        this.id_linie = id_linie;
        this.nume = nume;
        this.vecini = vecini;
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
