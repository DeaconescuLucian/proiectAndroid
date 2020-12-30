package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STATII_ABONAMENTE_PENTRU_STUDENTI")
public class StatiiAbonamentePentruStudenti
{
    @PrimaryKey
    @ColumnInfo(name = "ID")
    public int id;
    @ColumnInfo(name = "NUME_STATIE")
    public String nume_statie;

    @Override
    public String toString() {
        return "StatiiAbonamentePentruStudenti{" +
                "id=" + id +
                ", nume_statie='" + nume_statie + '\'' +
                ", ore='" + ore + '\'' +
                '}';
    }

    public StatiiAbonamentePentruStudenti(int id, String nume_statie, String ore) {
        this.id = id;
        this.nume_statie = nume_statie;
        this.ore = ore;
    }

    @ColumnInfo(name = "ORE")
    public String ore;
}
