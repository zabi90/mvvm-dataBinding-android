package io.devcrew.mvvmdatabinding.viewModel;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import io.devcrew.mvvmdatabinding.R;
import io.devcrew.mvvmdatabinding.model.Todo;
import io.devcrew.mvvmdatabinding.view.TodoDetailFragment;

/**
 * Created by zohaib on 17/04/2017.
 */

public class TodoDetailViewModel implements IViewModel {


    private Todo mTodo;
    private FragmentManager fragmentManager;
    private AppCompatActivity activity;

    public TodoDetailViewModel(AppCompatActivity activity,Todo todo){
        this.activity = activity;

        fragmentManager = this.activity.getSupportFragmentManager();

        TodoDetailFragment todoDetailFragment = TodoDetailFragment.newInstance(todo);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, todoDetailFragment);
        transaction.commit();

    }


    public Todo getTodo(){
        return mTodo;
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
