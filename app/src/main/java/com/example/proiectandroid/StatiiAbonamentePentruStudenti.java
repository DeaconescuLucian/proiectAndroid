package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "STATIIABONAMENTEPENTRUSTUDENTI")
public class StatiiAbonamentePentruStudenti
{
    @ColumnInfo(name = "ID")
    public int id;
    @ColumnInfo(name = "NUME_STATIE")
    public String nume_statie;
    @ColumnInfo(name = "ORE")
    public String ore;
}
