package com.example.proiectandroid;

public class Linie
{
    private int id_linie;
    private String start;
    private String end;

    public Linie(int id_linie, String start, String end) {
        this.id_linie = id_linie;
        this.start = start;
        this.end = end;
    }

    public int getId_linie() {
        return id_linie;
    }

    public void setId_linie(int id_linie) {
        this.id_linie = id_linie;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Linie{" +
                "id_linie=" + id_linie +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
