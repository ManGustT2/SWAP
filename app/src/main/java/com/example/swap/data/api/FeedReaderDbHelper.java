package com.example.swap.data.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.swap.data.api.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 25.12.2016.
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = FeedReaderDbHelper.class.getSimpleName();
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
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeadReaderContract.FeedEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void insertDB(List<Film> _films) {
        List<Film> film = new ArrayList<>();
        for (Film f : _films) {

            ContentValues newValues = new ContentValues();
            newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_EPISODE, f.getEpisode_id());
            newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_TITLE, f.getTitle());
            newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_CRAWL, f.getOpening_crawl());
            newValues.put(FeadReaderContract.FeedEntry.COLUMN_NAME_RELEASE, f.getRelease_date());

            long id = getWritableDatabase().update(DATABASE_NAME, newValues, FeadReaderContract.FeedEntry.COLUMN_NAME_EPISODE + " LIKE ?", new String[]{String.valueOf(f.getEpisode_id())});
            Log.d("KLYMENKO", "INSERT ID = " + id);
            if(id == 0) {
                getWritableDatabase().insert(DATABASE_NAME, null, newValues);
            }
        }
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
