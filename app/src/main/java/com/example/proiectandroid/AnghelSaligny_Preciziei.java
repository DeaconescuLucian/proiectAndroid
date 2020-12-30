package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ANGHELSALIGNY_PRECIZIEI")
public class AnghelSaligny_Preciziei
{
    @PrimaryKey()
    @NonNull
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

    public boolean selecteazaTimpiAsteptare(String ora_curenta)
    {
        String[] ore=this.interval_orar.split("-",2);

        if(ora_curenta.compareTo(ore[0])>0 && ora_curenta.compareTo(ore[1])<=1)
            return true;
        else
            return false;
    }
}
