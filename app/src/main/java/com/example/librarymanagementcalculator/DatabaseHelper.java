package com.example.librarymanagementcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    //table create
    private static final String DATABASE_NAME   = "retard.db";
    private static final int DATABASE_VERSION   = 1;
    private static final String TABLE_NAME      = "Nigga";
    private static final String ID_COLUM        = " ID";;
    private static final String BOOK_COLUM      = " NAME ";
    private static final String AUTHOR_COLUM    = " AUTHOR";


    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+
                "(  ID Integer PRIMARY KEY ,"+
                " NAME TEXT,"+
                " AUTHOR TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  boolean insertdata(String id,String name,String author)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put(BOOK_COLUM,name);
        cv.put(ID_COLUM,id);
        cv.put(AUTHOR_COLUM,author);
        long res = db.insert(TABLE_NAME,null,cv);
        if(res ==-1)
        {
            return false;
        }else{
            return true;
        }
    }
    public Cursor readData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor read = db.rawQuery("select * from "+ TABLE_NAME,null);
       return read;
   }

    public boolean updatedata(String id, String name, String author)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID_COLUM,id);
        cv.put(BOOK_COLUM,name);
        cv.put(AUTHOR_COLUM,author);
        db.update(TABLE_NAME,cv,"ID = ?",new String[]{id});
        return true;
        }
    public Integer deletedata(String id)
    {
         SQLiteDatabase db = this.getWritableDatabase();
         return db.delete(TABLE_NAME,"ID = ?",new String[]{id});

    }
}

