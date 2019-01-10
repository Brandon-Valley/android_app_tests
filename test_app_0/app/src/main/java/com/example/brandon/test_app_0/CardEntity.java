package com.example.brandon.test_app_0;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.support.annotation.NonNull;

//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;


///**
// * Room will use the Class name a sa default table name.
// *
// * This can be chagned by setting @Entity(tableName = "tableName")
// */
//@Entity
//public class CardEntity {
//
//    //entityID is simply a value based on the current date, to the second.
//    //Most importantly, it should always be a unique value, however you choose to determine it.
//    @PrimaryKey
//    @NonNull
//    private String entityID;
//    private String name;
////    private int colorResource;
//
//    public CardEntity(String entityID, String name, int colorResource) {
//        this.entityID = entityID;
//        this.name = name;
////        this.colorResource = colorResource;
//    }
//
////    public int getColorResource() {
////        return colorResource;
////    }
////
////    public void setColorResource(int colorResource) {
////        this.colorResource = colorResource;
////    }
//
//    public String getentityID() {
//        return entityID;
//    }
//
//    public void setentityID(String entityID) {
//        this.entityID = entityID;
//    }
//
//
//    public String getname() {
//        return name;
//    }
//
//    public void setname(String name) {
//        this.name = name;
//    }
//}


@Entity
public class CardEntity {
    @PrimaryKey
    public int uid;
    public String color = "RED";

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName = "smith";
}