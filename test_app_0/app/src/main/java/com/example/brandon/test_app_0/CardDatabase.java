package com.example.brandon.test_app_0;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
//import androidx.room.Database;
//import androidx.room.RoomDatabase;

@Database(entities = {CardEntity.class}, version = 1)
public abstract class CardDatabase extends RoomDatabase {
    public abstract CardDao CardDatabaseDao();
}