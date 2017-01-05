package com.example.swap.data.api.database;

import android.provider.BaseColumns;

/**
 * Created by Администратор on 25.12.2016.
 */
public final class FeadReaderContract {

    public FeadReaderContract(){

    }

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_EPISODE = "episode";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CRAWL = "opening_crawl";
        public static final String COLUMN_NAME_RELEASE = "release";
    }
}
