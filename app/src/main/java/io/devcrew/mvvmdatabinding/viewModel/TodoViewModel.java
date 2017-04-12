package io.devcrew.mvvmdatabinding.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.List;

import io.devcrew.mvvmdatabinding.dataModel.TodoDataModel;
import io.devcrew.mvvmdatabinding.model.Todo;
import io.devcrew.mvvmdatabinding.view.MainActivity;
import io.devcrew.mvvmdatabinding.view.TodoListActivity;

/**
 * Created by zohaib on 12/04/2017.
 */

public class TodoViewModel implements IViewModel,TodoDataModel.UserDataListener{

    public Context mContext;
    public ObservableField<String> description;
    public ObservableInt isProgressVisible;
    public TodoDataModel mTodoDataModel;
    public Activity mActivity;

    public TodoViewModel(Context context){
        mActivity = (Activity) context;
        description = new ObservableField<>();
        isProgressVisible = new ObservableInt();
        isProgressVisible.set(View.INVISIBLE);
        mContext = context;
        mTodoDataModel = new TodoDataModel(this);
    }

    public void saveUser(){
        isProgressVisible.set(View.VISIBLE);
        Todo todo = new Todo();
        todo.setDescription(description.get());
        mTodoDataModel.saveUser(todo);
    }



    public TextWatcher onNameTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                description.set(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }

    @Override
    public void onSaveUser() {
        isProgressVisible.set(View.INVISIBLE);
        mActivity.finish();
    }

    @Override
    public void onTodoListFetched(List<Todo> todoList) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
