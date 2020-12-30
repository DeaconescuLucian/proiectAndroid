package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnghelSaligny_PrecizieiDAO
{
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    public void insertAnghelSaligny_Preciziei(AnghelSaligny_Preciziei anghelSaligny_preciziei);

    @Delete
    public void deleteAnghelSaligny_Preciziei(AnghelSaligny_Preciziei anghelSaligny_preciziei);

    @Query("SELECT TIMPUL FROM ANGHELSALIGNY_PRECIZIEI")
    List<Integer> getTimpiAnghelSaligny_Preciziei();

    @Query("SELECT * FROM ANGHELSALIGNY_PRECIZIEI")
    List<AnghelSaligny_Preciziei> getAnghelSaligny_Preciziei();
}
