package io.devcrew.mvvmdatabinding.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import io.devcrew.mvvmdatabinding.model.Todo;

/**
 * Created by zohaib on 12/04/2017.
 */

public class TodoItemViewModel extends BaseObservable {

    public Todo mTodo;

    public TodoItemViewModel(Todo todo){
        mTodo = todo;
    }

    @Bindable
    public String getDescription() {
        return mTodo.getDescription();
    }

    @Bindable
    public boolean getStatus(){
        return mTodo.isStatus();
    }

}
