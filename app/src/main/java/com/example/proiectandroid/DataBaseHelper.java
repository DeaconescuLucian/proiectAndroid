package com.example.proiectandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String MAGISTRALE = "MAGISTRALE";
    public static final String ID_MAGISTRALA = "ID_MAGISTRALA";
    public static final String NUME_MAGISTRALA = "NUME_MAGISTRALA";
    public static final String ID_STATIE = "ID_STATIE";
    public static final String BAI = "BAI";
    public static final String MAGAZIN = "MAGAZIN";
    public static final String ID_VECIN_1 = "ID_VECIN1";
    public static final String ID_VECIN_2 = "ID_VECIN2";
    public static final String ID_VECIN_3 = "ID_VECIN3";
    public static final String STATII = "STATII";
    public static final String NUME_STATIE = "NUME_STATIE";
    public static final String TIMPUL = "TIMPUL";
    public static final String INTERVAL_ORAR = "INTERVAL_ORAR";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "metrorex.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String statement= "CREATE TABLE " + MAGISTRALE + " ( " + ID_MAGISTRALA + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NUME_MAGISTRALA + " TEXT );";
            db.execSQL(statement);
            String statement2= "CREATE TABLE " + STATII + " ( " + ID_STATIE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ID_MAGISTRALA + " INTEGER, "  + NUME_STATIE + " TEXT, " + BAI + " BOOL , " + MAGAZIN + " BOOL, " + ID_VECIN_1 + " INTEGER, " + ID_VECIN_2 + " INTEGER, " + ID_VECIN_3 + " INTEGER" +
                    ", FOREIGN KEY(ID_MAGISTRALA) REFERENCES "+ MAGISTRALE + " (ID_MAGISTRALA), FOREIGN KEY(" + ID_VECIN_1 + ") REFERENCES " + STATII +" (ID_STATIE) , FOREIGN KEY(ID_VECIN2) REFERENCES " + STATII + " (ID_STATIE), FOREIGN KEY(ID_VECIN3) REFERENCES " + STATII + " (ID_STATIE)  );";
            db.execSQL(statement2);
            String statement3= "CREATE TABLE LEGATURI ( " + ID_VECIN_1 +" INTEGER, " + ID_VECIN_2 + " INTEGER, " + " " + TIMPUL + " INTEGER, FOREIGN KEY(" + ID_VECIN_1 + ") REFERENCES " + STATII +" (ID_STATIE) , FOREIGN KEY(ID_VECIN2) REFERENCES " + STATII + " (ID_STATIE)" +  ")";
            db.execSQL(statement3);
            String statement4= "CREATE TABLE SCHIMBARI ( " + ID_VECIN_1 +" INTEGER, " + ID_VECIN_2 + " INTEGER, " + " " + TIMPUL + " INTEGER, FOREIGN KEY(" + ID_VECIN_1 + ") REFERENCES " + STATII +" (ID_STATIE) , FOREIGN KEY(ID_VECIN2) REFERENCES " + STATII + " (ID_STATIE)" +  ")";
            db.execSQL(statement4);
            String statement5= "CREATE TABLE REPUBLICA_DRISTOR2 ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement5);
            String statement6= "CREATE TABLE REPUBLICA_PANTELIMON ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement6);
            String statement7= "CREATE TABLE ANGHELSALIGNY_PRECIZIEI ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement7);
            String statement8= "CREATE TABLE DRISTOR1_EROILOR ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement8);
            String statement9= "CREATE TABLE GARADENORD2_STRAULESTI ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement9);
            String statement10= "CREATE TABLE PIPERA_BERCENI ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement10);
            String statement11= "CREATE TABLE EROILOR2_ROMANCIERILOR ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement11);
            String statement12= "CREATE TABLE RAULDOAMNEI_EROILOR2 ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement12);
            String statement13= "CREATE TABLE VALEAIALOMITEI_EROILOR2 ( " + INTERVAL_ORAR + " TEXT, TIMPUL INTEGER )";
            db.execSQL(statement13);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insereazaStatie(Statie statie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NUME_STATIE, statie.getNume());
        cv.put(ID_MAGISTRALA,statie.getId_magistrala());
        cv.put(BAI,statie.getBaie());
        cv.put(MAGAZIN,statie.getMancare());
        cv.put(ID_VECIN_1,statie.getId_vecin1());
        cv.put(ID_VECIN_2,statie.getId_vecin2());
        cv.put(ID_VECIN_3,statie.getId_vecin3());
        long succes=db.insert(STATII,null,cv);
        db.close();
        if(succes==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
