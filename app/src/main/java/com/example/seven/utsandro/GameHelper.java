package com.example.seven.utsandro;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameHelper extends SQLiteOpenHelper {
    private static final String NAMA_DB = "game.db";
    private static final String NAMA_TABEL = "game";
    private static final int VERSI_DB = 3;

    private static final String ID = "id";
    private static final String NAMA = "nama";
    private static final String GENRE = " genre";
    private static final String RATING = "rating";
    private static final String DEVELOPER = "developer";

    private static final String CREATE_TABLE = "CREATE TABLE "
            + NAMA_TABEL + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAMA + " VARCHAR(255), "
            + GENRE + " VARCHAR(255),"
            + RATING + " VARCHAR(255),"
            + DEVELOPER + " VARCHAR(255));";
    private static final String CREATE_TABLE_REVISI = "CREATE TABLE "
            + NAMA_TABEL + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAMA + " VARCHAR(255), "
            + GENRE + " VARCHAR(255),"
            + RATING + " VARCHAR(255),"
            + DEVELOPER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NAMA_TABEL;

    public GameHelper(Context context){
        super(context,NAMA_DB,null,VERSI_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<3){
            db.execSQL(DROP_TABLE);
            db.execSQL(CREATE_TABLE_REVISI);
        }
    }
}
