package com.example.proiectandroid;

public class StatieAbonamenteStudenti {

    private String nume;
    private String ore;

    public StatieAbonamenteStudenti(String nume, String ore) {
        this.nume = nume;
        this.ore = ore;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getOre() {
        return ore;
    }

    public void setOre(String ore) {
        this.ore = ore;
    }

    @Override
    public String toString() {
        return "StatieCuBaie{" +
                "nume='" + nume + '\'' +
                ", ore='" + ore + '\'' +
                '}';
    }
}
