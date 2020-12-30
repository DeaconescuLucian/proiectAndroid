package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STATII")
public class Statie
{
    @ColumnInfo(name = "ID_STATIE")
    public int id;
    @ColumnInfo(name = "ID_LINIE")
    public int id_linie;
    @ColumnInfo(name = "NUME_STATIE")
    public String nume_statie;
    @ColumnInfo(name = "VECINI")
    public String vecini;

    @Override
    public String toString() {
        return "Statie{" +
                "id=" + id +
                ", id_linie=" + id_linie +
                ", nume_statie='" + nume_statie + '\'' +
                ", vecini='" + vecini + '\'' +
                '}';
    }

    public Statie(int id, int id_linie, String nume_statie, String vecini) {
        this.id = id;
        this.id_linie = id_linie;
        this.nume_statie = nume_statie;
        this.vecini = vecini;
    }
}
