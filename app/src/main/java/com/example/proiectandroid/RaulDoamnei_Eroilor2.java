package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RAULDOAMNEI_EROILOR2")
public class RaulDoamnei_Eroilor2
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    @Override
    public String toString() {
        return "RaulDoamnei_Eroilor2{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }

    public RaulDoamnei_Eroilor2(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }
}
