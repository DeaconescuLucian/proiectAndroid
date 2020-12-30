package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface LinieDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertLinie(Linie linie);

    @Delete
    public void deleteLinie(Linie linie);

    @Query("SELECT * FROM LINII")
    List<Linie> getLinii();
}
