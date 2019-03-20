package com.example.countries.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country implements Parcelable {

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    @SerializedName("name")
    public String name;
    @SerializedName("borders")
    public List<String> borders;

    protected Country(Parcel in) {
        name = in.readString();
        borders = in.createStringArrayList();
    }

    public String getName() {
        return name;
    }

    public List<String> getBorders() {
        return borders;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeStringList(borders);
    }
}
