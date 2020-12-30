package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Republica_PantelimonDAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertRepublica_Pantelimon(Republica_Pantelimon republica_pantelimon);

    @Delete
    public void deleteRepublica_Pantelimon(Republica_Pantelimon republica_pantelimon);

    @Query("SELECT TIMPUL FROM REPUBLICA_PANTELIMON")
    List<Integer> getTimpiRepublica_Pantelimon();
}
