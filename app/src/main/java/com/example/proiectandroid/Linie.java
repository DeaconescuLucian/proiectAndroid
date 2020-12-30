package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LINII")
public class Linie
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_LINIE")
    public int id;
    @ColumnInfo(name = "START")
    public String start;
    @ColumnInfo(name = "END")
    public String end;

    @Override
    public String toString() {
        return "Linie{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public Linie(int id, String start, String end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}
