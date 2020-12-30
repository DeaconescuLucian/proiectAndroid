package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "EROILOR2_ROMANCIERILOR")
public class Eroilor2_Romancierilor
{
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    @Override
    public String toString() {
        return "Eroilor2_Romancierilor{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }

    public Eroilor2_Romancierilor(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }
}
