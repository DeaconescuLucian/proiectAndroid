//package com.example.proiectandroid;
//
//import android.content.Context;
//import android.content.res.AssetManager;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataBaseHelper extends SQLiteOpenHelper {
//    public static final String STATII = "STATII";
//    public static final String DATABASE_NAME = "metrorex.db";
//
//    private AssetManager assets;
//    private String databaseDir;
//    public DataBaseHelper(@Nullable Context context) {
//
//        super(context, "metrorex.db", null, 1);
//        assets = context.getAssets();
//        databaseDir = context.getApplicationInfo().dataDir + "/databases/";
//
//        File file = new File(databaseDir);
//        if(!file.exists()) file.mkdir();
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//    }
//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        copyDatabase();
//    }
//
////    trebuie modificata
////    public boolean insereazaStatie(Statie statie)
////    {
////        SQLiteDatabase db=this.getWritableDatabase();
////        ContentValues cv=new ContentValues();
////        cv.put(ID_STATIE,statie.getId_statie());
////        cv.put(NUME_STATIE, statie.getNume());
////        //to be contiunued
////        long succes=db.insert(STATII,null,cv);
////        db.close();
////        if(succes==-1)
////        {
////            return false;
////        }
////        else
////        {
////            return true;
////        }
////    }
////
////    public boolean insereazaLegaturi(Legaturi legatura,String tabela)
////    {
////        SQLiteDatabase db=this.getWritableDatabase();
////        ContentValues cv=new ContentValues();
////        cv.put(ID_VECIN_1,legatura.getId_vecin1());
////        cv.put(ID_VECIN_2,legatura.getId_vecin2());
////        cv.put(TIMPUL,legatura.getTimp());
////        long succes=db.insert(tabela,null,cv);
////        db.close();
////        if(succes==-1)
////        {
////            return false;
////        }
////        else
////        {
////            return true;
////        }
////    }
////
////    public boolean insereazaLinie(Linie line)
////    {
////        SQLiteDatabase db=this.getWritableDatabase();
////        ContentValues cv=new ContentValues();
////        cv.put("START",line.getStart());
////        cv.put("END",line.getEnd());
////        long succes=db.insert(LINII,null,cv);
////        db.close();
////        if(succes==-1)
////        {
////            return false;
////        }
////        else
////        {
////            return true;
////        }
////    }
////
////    public boolean insereazaTimpDeAsteptare(TimpiAsteptare ta,String Linie)
////    {
////        SQLiteDatabase db=this.getWritableDatabase();
////        ContentValues cv=new ContentValues();
////        cv.put(INTERVAL_ORAR,ta.getInterval_orar());
////        cv.put(TIMPUL,ta.getTimp());
////        long succes=db.insert(Linie,null,cv);
////        if(succes==-1)
////        {
////            return false;
////        }
////        else
////        {
////            return true;
////        }
////    }
//
//    public Statie1 selecteazaStatie(int id)
//    {
//        Statie1 statie=null;
//        String query="SELECT * FROM "+STATII +" WHERE ID_STATIE = "+id;
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query,null);
//        if(cursor.moveToFirst())
//        {
//            do{
//                int id_statie=cursor.getInt(0);
//                int id_linie=cursor.getInt(1);
//                String nume=cursor.getString(2);
//                String v=cursor.getString(3);
//                String[] vecini;
//                if (v!=null)
//                {
//                    vecini=v.split(",",0);
//                }
//                else
//                {
//                    vecini=null;
//                }
//
//                statie=new Statie1(id_statie,id_linie,nume,vecini);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return statie;
//    }
//
//    public List<Statie1> selecteazaStatii()
//    {
//        List<Statie1> returnList=new ArrayList<>();
//        String query="SELECT * FROM "+STATII;
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query,null);
//        if(cursor.moveToFirst())
//        {
//            do{
//                int id_statie=cursor.getInt(0);
//                int id_linie=cursor.getInt(1);
//                String nume=cursor.getString(2);
//                String v=cursor.getString(3);
//                String[] vecini;
//                if (v!=null)
//                {
//                    vecini=v.split(",",0);
//                }
//                else
//                {
//                    vecini=null;
//                }
//
//                Statie1 statie=new Statie1(id_statie,id_linie,nume,vecini);
//
//                returnList.add(statie);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//    public ArrayList<Statie1> selecteazaStatii(int id)
//    {
//        ArrayList<Statie1> returnList=new ArrayList<>();
//        String query="SELECT * FROM "+STATII +" WHERE ID_LINIE = "+id;
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query,null);
//        if(cursor.moveToFirst())
//        {
//            do{
//                int id_statie=cursor.getInt(0);
//                int id_linie=cursor.getInt(1);
//                String nume=cursor.getString(2);
//                String v=cursor.getString(3);
//                String[] vecini;
//                if (v!=null)
//                {
//                    vecini=v.split(",",0);
//                }
//                else
//                {
//                    vecini=null;
//                }
//
//                Statie1 statie=new Statie1(id_statie,id_linie,nume,vecini);
//
//                returnList.add(statie);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//    public ArrayList<Legaturi1> selecteazaLegaturi()
//    {
//        ArrayList<Legaturi1> returnList=new ArrayList<>();
//        String query="SELECT * FROM  LEGATURI";
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query,null);
//        if(cursor.moveToFirst())
//        {
//            do{
//                int v1=cursor.getInt(0);
//                int v2=cursor.getInt(1);
//                int timp=cursor.getInt(2);
//                Legaturi1 leg=new Legaturi1(v1,v2,timp);
//                returnList.add(leg);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//    public TimpAsteptare selecteazaTimpDeAsteptare(String tabela, String ora_curenta)
//    {
//        TimpAsteptare timp=null;
//        String query="SELECT * FROM  "+tabela;
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query,null);
//        if(cursor.moveToFirst())
//        {
//            do{
//                String interval=cursor.getString(0);
//                String[] ore=interval.split("-",2);
//                int timpul=cursor.getInt(1);
//                if(ora_curenta.compareTo(ore[0])>0 && ora_curenta.compareTo(ore[1])<=1)
//                    timp=new TimpAsteptare(interval,timpul);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return timp;
//    }
//
//    public List<Linie1> selecteazaLinii()
//    {
//        List<Linie1> returnList=new ArrayList<>();
//        String query="SELECT * FROM LINII";
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query, null);
//        if(cursor.moveToFirst())
//        {
//            do {
//                int id_linie=cursor.getInt(0);
//                String start=cursor.getString(1);
//                String end=cursor.getString(0);
//                Linie1 linie =new Linie1(id_linie, start,end);
//                returnList.add(linie);
//            }
//            while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//    public List<StatieAbonamenteStudenti> selecteazaStatiiAbonamente()
//    {
//        List<StatieAbonamenteStudenti> returnList=new ArrayList<>();
//        String query="SELECT * FROM STATII_ABONAMENTE_PENTRU_STUDENTI";
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query, null);
//        if(cursor.moveToFirst())
//        {
//            do {
//                String nume=cursor.getString(1);
//                String ore=cursor.getString(2);
//                StatieAbonamenteStudenti statie =new StatieAbonamenteStudenti(nume,ore);
//                returnList.add(statie);
//            }
//            while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//    public List<String> selecteazaStatiiBai()
//    {
//        List<String> returnList=new ArrayList<>();
//        String query="SELECT * FROM STATII_CU_BAI";
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(query, null);
//        if(cursor.moveToFirst())
//        {
//            do {
//                String nume=cursor.getString(1);
//                String statie =nume;
//                returnList.add(nume);
//            }
//            while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//
//    @Override
//    public SQLiteDatabase getWritableDatabase() {
//        if(!isDatabaseExist())
//            copyDatabase();
//        return super.getWritableDatabase();
//    }
//
//    @Override
//    public SQLiteDatabase getReadableDatabase() {
//        if(!isDatabaseExist())
//            copyDatabase();
//        return super.getReadableDatabase();
//    }
//
//
//    private Boolean isDatabaseExist() {
//        return new File(databaseDir + DATABASE_NAME).exists();
//    }
//
//    private void copyDatabase() {
//
//        try {
//            InputStream inputStream = assets.open("databases/" + DATABASE_NAME);
//
//            FileOutputStream outputStream = new FileOutputStream(databaseDir + DATABASE_NAME);
//
//            byte[] buffer = new byte[8 * 1024];
//
//            int readed;
//            while ((readed = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, readed);
//            }
//
//            outputStream.flush();
//
//            outputStream.close();
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//}
