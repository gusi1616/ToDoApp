package com.gusi1616.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.gusi1616.todoapp.ViewTodoActivity.EXTRA_TODO_INDEX;

public class PickTodoActivity extends AppCompatActivity {
    public static final String EXTRA_TODO_SELECT = "todoSelOrDel";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_todo);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<Data.ToDo>(
                this,
                android.R.layout.simple_list_item_1,
                Data.todos
        ));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selection = getIntent().getIntExtra(EXTRA_TODO_SELECT, -1);
                if(selection == 0){
                    Intent intentView = new Intent(PickTodoActivity.this, ViewTodoActivity.class);
                    intentView.putExtra(EXTRA_TODO_INDEX, position);
                    startActivity(intentView);
                }
                else{
                    Intent intentDel = new Intent(PickTodoActivity.this, DeleteTodoActivity.class);
                    intentDel.putExtra(EXTRA_TODO_INDEX, position);
                    startActivityForResult(intentDel, 1);
                }

            }
        });
    }
    protected void onActivityResult(int reqCode, int resCode, Intent data){
        super.onActivityResult(reqCode, resCode, data);
        if(resCode == RESULT_OK && reqCode == 1){
            this.finish();
        }
    }
}

