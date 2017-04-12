package io.devcrew.mvvmdatabinding.dataModel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import io.devcrew.mvvmdatabinding.model.Todo;
import io.realm.Realm;

import static org.junit.Assert.*;

/**
 * Created by zohaib on 12/04/2017.
 */

public class TodoDataModelTest {

    @Test
    public void saveUser() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Realm.init(appContext);
        TodoDataModel todoDataModel = new TodoDataModel(new TodoDataModel.TodoDataListener() {
            @Override
            public void onSaveUser() {

            }

            @Override
            public void onTodoListFetched(List<Todo> todoList) {

            }
        });
        Todo todo = new Todo();
        todo.setDescription("HelloWord");
        todoDataModel.saveUser(todo);
    }

    @Test
    public void getAllTodosList() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Realm.init(appContext);
        TodoDataModel todoDataModel = new TodoDataModel(new TodoDataModel.TodoDataListener() {
            @Override
            public void onSaveUser() {

            }

            @Override
            public void onTodoListFetched(List<Todo> todoList) {
                assertEquals(1,todoList.size());
            }
        });
        todoDataModel.getAllTodos();
    }

    @Test
    public void completeTodo() throws Exception {

    }

}