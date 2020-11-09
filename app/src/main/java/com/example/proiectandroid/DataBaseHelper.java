package com.example.proiectandroid;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String LINII = "LINII";
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
    public static final String DATABASE_NAME = "metrorex.db";

    private AssetManager assets;
    private String databaseDir;
    public DataBaseHelper(@Nullable Context context) {

        super(context, "metrorex.db", null, 1);
        assets = context.getAssets();
        databaseDir = context.getApplicationInfo().dataDir + "/databases/";

        File file = new File(databaseDir);
        if(!file.exists()) file.mkdir();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        copyDatabase();
    }

    //trebuie modificata
    public boolean insereazaStatie(Statie statie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ID_STATIE,statie.getId_statie());
        cv.put(NUME_STATIE, statie.getNume());
        //to be contiunued
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

    public boolean insereazaLegaturi(Legaturi legatura,String tabela)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ID_VECIN_1,legatura.getId_vecin1());
        cv.put(ID_VECIN_2,legatura.getId_vecin2());
        cv.put(TIMPUL,legatura.getTimp());
        long succes=db.insert(tabela,null,cv);
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

    public boolean insereazaLinie(Linie line)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("START",line.getStart());
        cv.put("END",line.getEnd());
        long succes=db.insert(LINII,null,cv);
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

    public boolean insereazaTimpDeAsteptare(TimpiAsteptare ta,String Linie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(INTERVAL_ORAR,ta.getInterval_orar());
        cv.put(TIMPUL,ta.getTimp());
        long succes=db.insert(Linie,null,cv);
        if(succes==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public List<Statie> selecteazaStatii()
    {
        List<Statie> returnList=new ArrayList<>();
        String query="SELECT * FROM "+STATII;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int id_statie=cursor.getInt(0);
                int id_linie=cursor.getInt(1);
                String nume=cursor.getString(2);
                String v=cursor.getString(3);
                String[] vecini;
                if (v!=null)
                {
                    vecini=v.split(",",0);
                }
                else
                {
                    vecini=null;
                }

                Statie statie=new Statie(id_statie,id_linie,nume,vecini);

                returnList.add(statie);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Legaturi> selecteazaLegaturi()
    {
        List<Legaturi> returnList=new ArrayList<>();
        String query="SELECT * FROM  LEGATURI";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int v1=cursor.getInt(0);
                int v2=cursor.getInt(1);
                int timp=cursor.getInt(2);
                Legaturi leg=new Legaturi(v1,v2,timp);
                returnList.add(leg);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Legaturi> selecteazaSchimbari()
    {
        List<Legaturi> returnList=new ArrayList<>();
        String query="SELECT * FROM  SCHIMBARI";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int v1=cursor.getInt(0);
                int v2=cursor.getInt(1);
                int timp=cursor.getInt(2);
                Legaturi leg=new Legaturi(v1,v2,timp);
                returnList.add(leg);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<TimpiAsteptare> selecteazaTimpiDeAsteptare(String tabela)
    {
        List<TimpiAsteptare> returnList=new ArrayList<>();
        String query="SELECT * FROM  "+tabela;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                String interval=cursor.getString(0);
                int timp=cursor.getInt(1);
                TimpiAsteptare timpi=new TimpiAsteptare(interval,timp);
                returnList.add(timpi);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Linie> selecteazaMagistrala(String tabela)
    {
        List<Linie> returnList=new ArrayList<>();
//        String query="SELECT * FROM "+tabela;
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query, null);
//        if(cursor.moveToFirst())
//        {
//            do {
//                int id_magistrala=cursor.getInt(0);
//                String nume=cursor.getString(1);
//                Linie linie =new Linie(id_magistrala, nume);
//                returnList.add(linie);
//            }
//            while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
        return returnList;
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        if(!isDatabaseExist())
            copyDatabase();
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        if(!isDatabaseExist())
            copyDatabase();
        return super.getReadableDatabase();
    }


    private Boolean isDatabaseExist() {
        return new File(databaseDir + DATABASE_NAME).exists();
    }

    private void copyDatabase() {

        try {
            InputStream inputStream = assets.open("databases/" + DATABASE_NAME);

            FileOutputStream outputStream = new FileOutputStream(databaseDir + DATABASE_NAME);

            byte[] buffer = new byte[8 * 1024];

            int readed;
            while ((readed = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readed);
            }

            outputStream.flush();

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
