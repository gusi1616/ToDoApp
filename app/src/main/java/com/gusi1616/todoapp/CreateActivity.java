package com.gusi1616.todoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.gusi1616.todoapp.Data.todos;

public class CreateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);
    }
    public void createButtonClickedCreate(View view){
        System.out.println("Todo Created");
        EditText editText = (EditText) findViewById(R.id.enteredTitle);
        String enteredTitle = editText.getText().toString();
        todos.add(new Data.ToDo(enteredTitle));
        System.out.println(todos.size());
        finish();
    }

}
