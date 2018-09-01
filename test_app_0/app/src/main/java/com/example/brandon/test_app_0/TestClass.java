package com.example.brandon.test_app_0;

import android.os.Parcel;
import android.os.Parcelable;

//import java.io.Serializable;


@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class TestClass implements Parcelable {
    public int testInt = 0;



    /* all your getter and setter methods */

    public TestClass() {
        testInt = 0;
    }


    public TestClass(Parcel in ) {
        readFromParcel( in );
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Object createFromParcel(Parcel in ) {
            return new TestClass( in );
        }

        public TestClass[] newArray(int size) {
            return new TestClass[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

//        dest.writeString(firstName);
//        dest.writeString(lastName);
//        dest.writeString(address);
        dest.writeInt(testInt);
    }

    private void readFromParcel(Parcel in ) {

//        firstName = in .readString();
//        lastName  = in .readString();
//        address   = in .readString();
        testInt = in.readInt();


    }


}
