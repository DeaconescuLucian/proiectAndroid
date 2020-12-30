package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RaulDoamnei_Eroilor2DAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertRaulDoamnei_Eroilor2(RaulDoamnei_Eroilor2 raulDoamnei_eroilor2);

    @Delete
    public void deleteRaulDoamnei_Eroilor2(RaulDoamnei_Eroilor2 raulDoamnei_eroilor2);

    @Query("SELECT TIMPUL FROM RAULDOAMNEI_EROILOR2")
    List<Integer> getTimpiRaulDoamnei_Eroilor2();
}
