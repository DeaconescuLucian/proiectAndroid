package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STATII_CU_BAI")
public class Statii_cu_bai
{
    @PrimaryKey
    @ColumnInfo(name = "ID")
    public int id;
    @ColumnInfo(name = "NUME_STATIE")
    public String nume_statie;

    @Override
    public String toString() {
        return "Statii_cu_bai{" +
                "id=" + id +
                ", nume_statie='" + nume_statie + '\'' +
                '}';
    }

    public Statii_cu_bai(int id, String nume_statie) {
        this.id = id;
        this.nume_statie = nume_statie;
    }
}
