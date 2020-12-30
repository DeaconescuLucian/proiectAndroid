package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Republica_Dristor2DAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertRepublica_Dristor2(Republica_Dristor2 republica_dristor2);

    @Delete
    public void deleteRepublica_Dristor2(Republica_Dristor2 republica_dristor2);

    @Query("SELECT TIMPUL FROM REPUBLICA_DRISTOR2")
    List<Integer> getTimpiRepublica_Dristor2();

    @Query("SELECT * FROM REPUBLICA_DRISTOR2")
    List<Republica_Dristor2> getRepublica_Dristor2();
}
