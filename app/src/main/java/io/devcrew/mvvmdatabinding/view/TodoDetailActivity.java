package io.devcrew.mvvmdatabinding.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.devcrew.mvvmdatabinding.R;
import io.devcrew.mvvmdatabinding.databinding.ActivityTodoDetailBinding;
import io.devcrew.mvvmdatabinding.model.Todo;
import io.devcrew.mvvmdatabinding.viewModel.TodoDetailViewModel;

public class TodoDetailActivity extends AppCompatActivity {

    private  TodoDetailViewModel mTodoDetailModel;
    ActivityTodoDetailBinding mTodoDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todo_detail);
        mTodoDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_todo_detail);
        getTodoIntent();
    }

    private void getTodoIntent() {
        Todo todo = getIntent().getParcelableExtra(Todo.TODO);
        mTodoDetailModel = new TodoDetailViewModel(this,todo);
        mTodoDetailBinding.setTodoDetailViewModel(mTodoDetailModel);

    }


}
