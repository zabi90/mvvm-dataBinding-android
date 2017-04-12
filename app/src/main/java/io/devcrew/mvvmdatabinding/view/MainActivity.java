package io.devcrew.mvvmdatabinding.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.devcrew.mvvmdatabinding.R;
import io.devcrew.mvvmdatabinding.databinding.ActivityMainBinding;
import io.devcrew.mvvmdatabinding.viewModel.TodoViewModel;

public class MainActivity extends AppCompatActivity {

    private TodoViewModel mTodoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mTodoViewModel = new TodoViewModel(this);
        activityMainBinding.setUserViewModel(mTodoViewModel);
    }

}
