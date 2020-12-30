package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GaraDeNord_StraulestiDAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertGaraDeNord_Straulesti(GaraDeNord_Straulesti garaDeNord_straulesti);

    @Delete
    public void deleteGaraDeNord_Straulesti(GaraDeNord_Straulesti garaDeNord_straulesti);

    @Query("SELECT TIMPUL FROM GARADENORD_STRAULESTI")
    List<Integer> getTimpiGaraDeNord_Straulesti();
}
