package com.example.proiectandroid;

public class NodGraf extends Statie1 implements Comparable{

    private int distance;
    private int id_previous;
    private boolean vizitat;

    public NodGraf(int id_statie, int id_linie, String nume, String vecini) {
        super(id_statie, id_linie, nume, vecini);
        this.distance=1000000;
        this.id_previous=-1;
        this.vizitat=false;

    }

    public NodGraf()
    {
        this.distance=100000;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId_previous() {
        return id_previous;
    }

    public void setId_previous(int id_previous) {
        this.id_previous = id_previous;
    }

    public boolean isVizitat() {
        return vizitat;
    }

    public void setVizitat(boolean vizitat) {
        this.vizitat = vizitat;
    }

    @Override
    public String toString() {
        return "NodGraf{" +
                "distance=" + distance +
                ", id_previous=" + id_previous +" " +super.toString()+
                '}';
    }

    @Override
    public int compareTo(Object nod) {
        return this.distance-((NodGraf)nod).getDistance();
    }
}
