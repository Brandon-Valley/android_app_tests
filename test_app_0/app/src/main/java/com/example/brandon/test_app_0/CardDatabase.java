package com.example.brandon.test_app_0;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CardEntity.class}, version = 1)
public abstract class CardDatabase extends RoomDatabase {
    public abstract CardDao userDao();
}