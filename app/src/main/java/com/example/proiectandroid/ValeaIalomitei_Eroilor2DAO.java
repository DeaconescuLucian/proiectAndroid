package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ValeaIalomitei_Eroilor2DAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertValeaIalomitei_Eroilor2(ValeaIalomitei_Eroilor2 valeaIalomitei_eroilor2);

    @Delete
    public void deleteValeaIalomitei_Eroilor2(ValeaIalomitei_Eroilor2 valeaIalomitei_eroilor2);

    @Query("SELECT TIMPUL FROM VALEAIALOMITEI_EROILOR2")
    List<Integer> getTimpiValeaIalomitei_Eroilor2();
}
