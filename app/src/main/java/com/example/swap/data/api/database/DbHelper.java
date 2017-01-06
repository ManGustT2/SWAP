package com.example.swap.data.api.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.swap.data.api.model.Film;

import java.util.List;
/**
 * Created by Администратор on 25.12.2016.
 */
public class DbHelper extends SQLiteOpenHelper implements IFilmRepo {
    private static final String DB_NAME = "swap.sqlite";
    private static final int DB_VERSION = 1;

    //    Table name
    private static final String TABLE_EPISODE = "films";

    //    Table film column name
    private static final String EPISODE_ID = "id";    private static final String EPISODE_TITLE = "title";

    public DbHelper(Context _context) {
        super(_context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_EPISODE + " (" +
                "_id integer primary key autoincrement, " +
                EPISODE_ID + " integer, " + EPISODE_TITLE + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EPISODE);
        onCreate(db);
    }

    @Override
    public void insertFilms(List<Film> _list) {
        for(Film film : _list) {
            ContentValues cv = new ContentValues();
            cv.put(EPISODE_ID, film.getEpisode_id());
            cv.put(EPISODE_TITLE, film.getTitle());

            getWritableDatabase().insert(TABLE_EPISODE, null, cv);
        }
    }
}
