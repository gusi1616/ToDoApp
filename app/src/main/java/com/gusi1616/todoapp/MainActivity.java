package com.gusi1616.todoapp;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static com.gusi1616.todoapp.PickTodoActivity.EXTRA_TODO_SELECT;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createButtonClicked(View view){
        System.out.println("Button Clicked!");
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }
    public void createButtonClickedPick(View view){
        System.out.println("Pick clicked!");
        Intent selView = new Intent(this, PickTodoActivity.class);
        selView.putExtra(EXTRA_TODO_SELECT,0);
        startActivity(selView);
    }
    public void createButtonClickedDelete(View view){
        System.out.println("Delete clicked!");
        Intent selView = new Intent(this, PickTodoActivity.class);
        selView.putExtra(EXTRA_TODO_SELECT,1);
        startActivity(selView);
    }
}
