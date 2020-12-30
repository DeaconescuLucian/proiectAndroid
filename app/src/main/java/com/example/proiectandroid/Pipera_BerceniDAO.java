package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Pipera_BerceniDAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertPipera_Berceni(Pipera_Berceni pipera_berceni);

    @Delete
    public void deleteAnghelSaligny_Preciziei(Pipera_Berceni pipera_berceni);

    @Query("SELECT TIMPUL FROM PIPERA_BERCENI")
    List<Integer> getTimpiPipera_Berceni();

    @Query("SELECT * FROM PIPERA_BERCENI")
    List<Pipera_Berceni> getPipera_Berceni();
}
