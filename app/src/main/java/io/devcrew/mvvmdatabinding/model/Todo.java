package io.devcrew.mvvmdatabinding.model;

import io.realm.RealmObject;

/**
 * Created by zohaib on 12/04/2017.
 */

public class Todo extends RealmObject {

    private String description;
    private boolean status;

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
}
