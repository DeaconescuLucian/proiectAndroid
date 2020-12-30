package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "REPUBLICA_PANTELIMON")
public class Republica_Pantelimon
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    @Override
    public String toString() {
        return "Republica_Pantelimon{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }

    public Republica_Pantelimon(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }
}
