package com.gusi1616.todoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.gusi1616.todoapp.Data.todos;

public class ViewTodoActivity extends AppCompatActivity {
    private TextView textView;
    public static final String EXTRA_TODO_INDEX = "todoIndex";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo);
        int position = getIntent().getIntExtra(EXTRA_TODO_INDEX,-1);

        textView = (TextView) findViewById(R.id.viewToDo);
        textView.setText("Todo: "+todos.get(position).title);
    }
}
