package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StatiiAbonamentePentruStudentiDAO
{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    public void insertStatiiAbonamentePentruStudenti(StatiiAbonamentePentruStudenti statiiAbonamentePentruStudenti);

    @Delete
    public void deleteStatiiAbonamentePentruStudenti(StatiiAbonamentePentruStudenti statiiAbonamentePentruStudenti);

    @Query("SELECT * FROM STATIIABONAMENTEPENTRUSTUDENTI")
    List<StatiiAbonamentePentruStudenti> getStatiiAbonamentePentruStudenti();
}
