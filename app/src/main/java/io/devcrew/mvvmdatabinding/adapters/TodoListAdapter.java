package io.devcrew.mvvmdatabinding.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import io.devcrew.mvvmdatabinding.R;
import io.devcrew.mvvmdatabinding.databinding.ItemLayoutTodoBinding;
import io.devcrew.mvvmdatabinding.model.Todo;
import io.devcrew.mvvmdatabinding.viewModel.TodoItemViewModel;

/**
 * Created by zohaib on 12/04/2017.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.BindingHolder> {

    private List<Todo> mTodoList;
    private Context mContext;
    private TodoCompleteListener mTodoCompleteListener;

    public TodoListAdapter(List<Todo> todoList, Context context, TodoCompleteListener listener){
        mTodoList = todoList;
        mContext  = context;
        mTodoCompleteListener = listener;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         ItemLayoutTodoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_layout_todo, parent, false);

        return new BindingHolder(binding);

    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ItemLayoutTodoBinding binding = holder.binding;
        binding.setTodoItemViewModel(new TodoItemViewModel(mTodoList.get(position)));
        binding.setTodoCompleteListener(mTodoCompleteListener);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder{

        public ItemLayoutTodoBinding binding;

        public BindingHolder(ItemLayoutTodoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

    public interface TodoCompleteListener{
        void onDone(Todo todo);
        void onViewDetail(Todo todo);
    }
}
