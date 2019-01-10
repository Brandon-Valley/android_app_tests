package com.example.brandon.test_app_0;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//
//import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CardDao {
    @Query("SELECT * FROM CardEntity")
    List<CardEntity> getAll();

//    @Query("SELECT * FROM CardEntity WHERE uid IN (:CardEntityIds)")
//    List<CardEntity> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM CardEntity WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    CardEntity findByName(String first, String last);

//    @Insert
//    void insertAll(CardEntity... CardEntitys);

    //(onConflict = REPLACE)
    @Insert
    void insertCardEntity(CardEntity cardEntity);

    @Delete
    void delete(CardEntity CardEntity);
}

