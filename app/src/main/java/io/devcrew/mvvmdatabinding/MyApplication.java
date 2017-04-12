package io.devcrew.mvvmdatabinding;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by zohaib on 12/04/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
}
