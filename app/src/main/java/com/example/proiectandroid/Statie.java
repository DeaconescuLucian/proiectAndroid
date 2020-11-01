package com.example.proiectandroid;

public class Statie
{
    private int id_statie;
    private String nume;
    private int id_magistrala;
    private boolean baie;
    private boolean mancare;
    private int id_vecin1;
    private int id_vecin2;
    private  int id_vecin3;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Statie(int id_statie, String nume, int id_magistrala, boolean baie, boolean mancare, int id_vecin1, int id_vecin2, int id_vecin3) {
        this.id_statie = id_statie;
        this.nume = nume;
        this.id_magistrala = id_magistrala;
        this.baie = baie;
        this.mancare = mancare;
        this.id_vecin1 = id_vecin1;
        this.id_vecin2 = id_vecin2;
        this.id_vecin3 = id_vecin3;
    }

    public Statie()
    {

    }

    public int getId_statie() {
        return id_statie;
    }

    public void setId_statie(int id_statie) {
        this.id_statie = id_statie;
    }

    public int getId_magistrala() {
        return id_magistrala;
    }

    public void setId_magistrala(int id_magistrala) {
        this.id_magistrala = id_magistrala;
    }

    public boolean getBaie() {
        return baie;
    }

    public void setBaie(boolean baie) {
        this.baie = baie;
    }

    public boolean getMancare() {
        return mancare;
    }

    public void setMancare(boolean mancare) {
        this.mancare = mancare;
    }

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

    public int getId_vecin3() {
        return id_vecin3;
    }

    public void setId_vecin3(int id_vecin3) {
        this.id_vecin3 = id_vecin3;
    }

    @Override
    public String toString() {
        return "Statia{" +
                "nume"+nume+
                "id_statie=" + id_statie +
                ", id_magistrala=" + id_magistrala +
                ", baie=" + baie +
                ", mancare=" + mancare +
                ", id_vecin1=" + id_vecin1 +
                ", id_vecin2=" + id_vecin2 +
                ", id_vecin3=" + id_vecin3 +
                '}';
    }
}
