package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GARADENORD_STRAULESTI")
public class GaraDeNord_Straulesti
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "INTERVAL_ORAR")
    public String interval_orar;
    @ColumnInfo(name = "TIMPUL")
    public int timp;

    @Override
    public String toString() {
        return "GaraDeNord_Straulesti{" +
                "interval_orar='" + interval_orar + '\'' +
                ", timp=" + timp +
                '}';
    }

    public GaraDeNord_Straulesti(String interval_orar, int timp) {
        this.interval_orar = interval_orar;
        this.timp = timp;
    }
    public boolean selecteazaTimpiAsteptare(String ora_curenta)
    {
        String[] ore=this.interval_orar.split("-",2);

        if(ora_curenta.compareTo(ore[0])>0 && ora_curenta.compareTo(ore[1])<=1)
            return true;
        else
            return false;
    }
}
