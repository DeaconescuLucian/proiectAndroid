package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StatieDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertStatie(Statie statie);

    @Delete
    public void deleteStatie(Statie statie);

    @Query("SELECT * FROM STATII")
    List<Statie> getStatii();

    @Query("SELECT * FROM STATII WHERE ID_LINIE=:id_linie")
    List<Statie> getStatiiByIdLinie(int id_linie);

    @Query("SELECT * FROM STATII WHERE ID_LINIE=:id_statie")
    List<Statie> getStatiiByIdStatie(int id_statie);
}
