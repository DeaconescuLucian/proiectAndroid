package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LEGATURI")
public class Legaturi
{
    @PrimaryKey
    @ColumnInfo(name = "ID_VECIN1")
    public int id_vecin1;
    @ColumnInfo(name = "ID_VECIN2")
    public int id_vecin2;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    public Legaturi(int id_vecin1, int id_vecin2, int timp) {
        this.id_vecin1 = id_vecin1;
        this.id_vecin2 = id_vecin2;
        this.timp = timp;
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

