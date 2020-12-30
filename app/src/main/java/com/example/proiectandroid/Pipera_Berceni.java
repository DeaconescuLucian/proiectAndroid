package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PIPERA_BERCENI")
public class Pipera_Berceni
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    public Pipera_Berceni(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }

    @Override
    public String toString() {
        return "Pipera_Berceni{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }
}
