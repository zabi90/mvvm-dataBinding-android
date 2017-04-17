package io.devcrew.mvvmdatabinding.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by zohaib on 12/04/2017.
 */

public class Todo extends RealmObject implements Parcelable {
    public static final String TODO  = "TODO";
    private String description;
    private boolean status;

    public Todo(){
    }

    protected Todo(Parcel in) {
        description = in.readString();
        status = in.readByte() != 0;
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeByte((byte) (status ? 1 : 0));
    }
}
