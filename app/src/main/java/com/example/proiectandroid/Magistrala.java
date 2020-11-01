package com.example.proiectandroid;

public class Magistrala
{
    private int id_magistrala;
    private String nume;

    public int getId_magistrala() {
        return id_magistrala;
    }

    public void setId_magistrala(int id_magistrala) {
        this.id_magistrala = id_magistrala;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Magistrala(int id_magistrala, String nume) {
        this.id_magistrala = id_magistrala;
        this.nume = nume;
    }

    public Magistrala() {
    }

    @Override
    public String toString() {
        return "Magistrala{" +
                "id_magistrala=" + id_magistrala +
                ", nume='" + nume + '\'' +
                '}';
    }
}
