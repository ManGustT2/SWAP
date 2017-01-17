package com.example.swap.data.api.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.swap.data.api.model.Film;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Администратор on 25.12.2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "swap.sqlite";
    private static final int DB_VERSION = 1;

    //    Table name
    private static final String TABLE_EPISODE = "films";

    //    Table film column name
    private static final String EPISODE_ID = "id";
    private static final String EPISODE_TITLE = "title";

    public DBHelper(Context _context) {
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

    public void insertFilms(List<Film> _list) {
        getWritableDatabase().delete(TABLE_EPISODE, null, null);
        for (Film film : _list) {
            ContentValues cv = new ContentValues();
            cv.put(EPISODE_ID, film.getEpisode_id());
            cv.put(EPISODE_TITLE, film.getTitle());
            getWritableDatabase().insert(TABLE_EPISODE, null, cv);
        }
    }

    public List<Film> getListFilm() {

            List<Film> films = new ArrayList<>();
            Cursor c = getReadableDatabase().query(TABLE_EPISODE, null, null, null, null, null,null);
            if(c != null){
            while (c.moveToNext()){
               Film f = new Film();
                f.setEpisode_id(c.getColumnIndex(EPISODE_ID));
                f.setTitle(c.getString(c.getColumnIndex(EPISODE_TITLE)));

                films.add(f);
            }
        }

        return films;
    }

    public Film getDetailFilm(int id){
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE_EPISODE, new String[] { EPISODE_ID, EPISODE_TITLE}, EPISODE_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Film film = new Film();
        film.setEpisode_id(cursor.getColumnIndex(EPISODE_ID));
        film.setTitle(cursor.getString(cursor.getColumnIndex(EPISODE_TITLE)));
        return film;
    }
}
