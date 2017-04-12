package io.devcrew.mvvmdatabinding.dataModel;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import io.devcrew.mvvmdatabinding.model.Todo;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by zohaib on 12/04/2017.
 */

public class TodoDataModel {

    private UserDataListener mUserDataListener;

    public TodoDataModel(UserDataListener listener) {
        mUserDataListener = listener;
    }

    public void saveUser(final Todo todo) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.copyToRealm(todo);
                realm.commitTransaction();
                mUserDataListener.onSaveUser();
            }
        }, 2000);//We add delay for making it async task example
    }

    public void getAllTodos() {

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Todo> query = realm.where(Todo.class);
        RealmResults<Todo> resultTodos = query.findAll();
        mUserDataListener.onTodoListFetched(resultTodos);

    }

    public void completeTodo (final Todo todo){

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Todo todoItem = realm.where(Todo.class).equalTo("description",todo.getDescription()).findFirst();
                todoItem.setStatus(true);
            }
        });
    }

    public interface UserDataListener {
        void onSaveUser();
        void onTodoListFetched(List<Todo> todoList);
    }
}
