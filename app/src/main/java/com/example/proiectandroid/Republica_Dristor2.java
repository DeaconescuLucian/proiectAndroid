package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "REPUBLICA_DRISTOR2")
public class Republica_Dristor2
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    public Republica_Dristor2(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }

    @Override
    public String toString() {
        return "Republica_Dristor2{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }
}
