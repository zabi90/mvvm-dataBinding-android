package io.devcrew.mvvmdatabinding.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableInt;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.devcrew.mvvmdatabinding.adapters.TodoListAdapter;
import io.devcrew.mvvmdatabinding.dataModel.TodoDataModel;
import io.devcrew.mvvmdatabinding.model.Todo;
import io.devcrew.mvvmdatabinding.view.MainActivity;

/**
 * Created by zohaib on 12/04/2017.
 */

public class TodoListViewModel  implements IViewModel,TodoDataModel.UserDataListener, TodoListAdapter.TodoCompleteListener {

    private Context mContext;
    private Activity mActivity;
    private List<Todo> mTodoList;
    private TodoDataModel mTodoDataModel;
    private TodoListAdapter mAdapter;

    public ObservableInt progressBarVisibilty;
    private boolean isFirstTime = true;
    public TodoListViewModel(Context context){
        mContext  = context;
        mActivity = (Activity) context;
        progressBarVisibilty = new ObservableInt();
        mTodoList = new ArrayList<>();
        mTodoDataModel = new TodoDataModel(this);
    }

    public void openTodoActivity(){
        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
    }

    public TodoListAdapter setTodoAdapter(){
        mAdapter = new TodoListAdapter(mTodoList,mContext,this);
        mTodoDataModel.getAllTodos();
        return mAdapter;
    }

    public RecyclerView.LayoutManager setLayoutManager(){
        return new LinearLayoutManager(mContext);
    }


    @Override
    public void onResume() {
        progressBarVisibilty.set(View.VISIBLE);
        if(!isFirstTime){
            mTodoDataModel.getAllTodos();
        }

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

    @Override
    public void onSaveUser() {
    }

    @Override
    public void onTodoListFetched(List<Todo> todoList) {
        progressBarVisibilty.set(View.INVISIBLE);
        if(mTodoList.size()>0){
            mTodoList.clear();
        }
        mTodoList.addAll(todoList);
        mAdapter.notifyDataSetChanged();
        isFirstTime = false;
    }

    @Override
    public void onDone(Todo todo) {
        mTodoDataModel.completeTodo(todo);
        mTodoDataModel.getAllTodos();
    }
}
