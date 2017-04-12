package io.devcrew.mvvmdatabinding.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.devcrew.mvvmdatabinding.R;
import io.devcrew.mvvmdatabinding.adapters.TodoListAdapter;
import io.devcrew.mvvmdatabinding.databinding.ActivityTodoListBinding;
import io.devcrew.mvvmdatabinding.model.Todo;
import io.devcrew.mvvmdatabinding.viewModel.TodoListViewModel;
import io.devcrew.mvvmdatabinding.viewModel.TodoViewModel;

public class TodoListActivity extends AppCompatActivity {

    private TodoListViewModel mTodoListViewModel;
    private ActivityTodoListBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_todo_list);
        mTodoListViewModel = new TodoListViewModel(this);
        mBinding.setTodoListViewModel(mTodoListViewModel);
        setToolBar();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mTodoListViewModel.onResume();
    }

    private void setToolBar(){
        Toolbar toolbar = mBinding.toolbar;
        setSupportActionBar(toolbar);
    }
}
