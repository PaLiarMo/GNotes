package com.paliarmo.gbnote.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ENote implements Parcelable {
    Integer id;
    String name;
    String description;
    String createdAt;
    String updatedAt;

    public ENote() {

    }

    private ENote(Parcel in) {
        name = in.readString();
        description = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<ENote> CREATOR = new Creator<ENote>() {
        @Override
        public ENote createFromParcel(Parcel in) {
            return new ENote(in);
        }

        @Override
        public ENote[] newArray(int size) {
            return new ENote[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
    }
}
