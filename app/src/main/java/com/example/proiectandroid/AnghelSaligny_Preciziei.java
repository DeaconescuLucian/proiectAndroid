package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "ANGHELSALIGNY_PRECIZIEI")
public class AnghelSaligny_Preciziei
{
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    @Override
    public String toString() {
        return "AnghelSaligny_Preciziei{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }

    public AnghelSaligny_Preciziei(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }
}
