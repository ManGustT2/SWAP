package com.example.swap.data.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.swap.data.api.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 25.12.2016.
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";
    private Film mFilms;

    public FeedReaderDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeadReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeadReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeadReaderContract.FeedEntry.COLUMN_NAME_EPISODE + TEXT_TYPE + COMMA_SEP +
                    FeadReaderContract.FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    FeadReaderContract.FeedEntry.COLUMN_NAME_CRAWL + TEXT_TYPE + COMMA_SEP +
                    FeadReaderContract.FeedEntry.COLUMN_NAME_RELEASE +TEXT_TYPE + COMMA_SEP +" )";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        insertDB(mFilms, db);
    }

    public void insertDB(Film film,SQLiteDatabase db){
        ContentValues newValues = new ContentValues();
        newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_EPISODE, film.getEpisode_id());
        newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_TITLE, film.getTitle());
        newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_CRAWL, film.getOpening_crawl());
        newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_RELEASE, film.getRelease_date());
        db.insert(DATABASE_NAME, null, newValues);
    }


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeadReaderContract.FeedEntry.TABLE_NAME;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}