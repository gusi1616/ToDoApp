package com.gusi1616.todoapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.gusi1616.todoapp.Data.todos;

public class DeleteTodoActivity extends AppCompatActivity {
    private TextView textView;
    public int todoIndex;
    public static final String EXTRA_TODO_INDEX = "todoIndex";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_todo);
        int position = getIntent().getIntExtra(EXTRA_TODO_INDEX,-1);

        textView = (TextView) findViewById(R.id.deleteToDo);
        textView.setText("Todo: "+todos.get(position).title);
    }
    public void createButtonClickedDeleteOne(View view){
        new AlertDialog.Builder(this)
                .setTitle("Delete ToDo")
                .setMessage("Do you really want to delete it?")
                .setPositiveButton(
                        android.R.string.yes,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int whichButton){
                                todoIndex = getIntent().getExtras().getInt(EXTRA_TODO_INDEX);
                                Data.todos.remove(todoIndex);
                                setResult(RESULT_OK);
                                finish();
                            }
                        }
                ).setNegativeButton(
                android.R.string.no,
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){
                        setResult(RESULT_OK, null);
                    }
                }
        ).show();
    }
}
