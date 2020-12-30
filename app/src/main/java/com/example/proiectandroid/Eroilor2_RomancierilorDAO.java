package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Eroilor2_RomancierilorDAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertEroilor2_Romancierilor(Eroilor2_Romancierilor eroilor2_romancierilor);

    @Delete
    public void deleteEroilor2_Romancierilor(Eroilor2_Romancierilor eroilor2_romancierilor);

    @Query("SELECT TIMPUL FROM EROILOR2_ROMANCIERILOR")
    List<Integer> getTimpiEroilor2_Romancierilor();
}
