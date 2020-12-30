package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "STATII_CU_BAI")
public class Statii_cu_bai
{
    @ColumnInfo(name = "ID")
    public int id;
    @ColumnInfo(name = "NUME_STATIE")
    public String nume_statie;
}
