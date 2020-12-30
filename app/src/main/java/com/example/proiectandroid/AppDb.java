package com.example.proiectandroid;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Linie.class, Statie.class}, version = 2, exportSchema = true)
public abstract class AppDb extends RoomDatabase
{
//    public abstract LinieDAO linieDAO();
//
//    public abstract StatieDAO statieDAO();
//
//    public abstract AnghelSaligny_PrecizieiDAO anghelSaligny_precizieiDAO();
//
//    public abstract Dristor1_EroilorDAO dristor1_eroilorDAO();
//
//    public abstract Eroilor2_RomancierilorDAO eroilor2_romancierilorDAO();
//
//    public abstract GaraDeNord_StraulestiDAO garaDeNord_straulestiDAO();
//
//    public abstract LegaturiDAO legaturiDAO();
//
//    public abstract Pipera_BerceniDAO pipera_berceniDAO();
//
//    public abstract RaulDoamnei_Eroilor2DAO raulDoamnei_eroilor2DAO();
//
//    public abstract Republica_Dristor2DAO republica_dristor2DAO();
//
//    public abstract Republica_PantelimonDAO republica_pantelimonDAO();
//
//    public abstract StatiiAbonamentePentruStudentiDAO statiiAbonamentePentruStudentiDAO();
//
//    public abstract Statii_cu_baiDAO statii_cu_baiDAO();
//
//    public abstract ValeaIalomitei_Eroilor2DAO valeaIalomitei_eroilor2DAO();




}
