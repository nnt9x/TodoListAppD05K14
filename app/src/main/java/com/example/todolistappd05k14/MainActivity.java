package com.example.todolistappd05k14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvTodos;
    private List<Todo> dataSource;

    private TodoDialog todoDialog = null;
    private TodoAdapter todoAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTodos = findViewById(R.id.lv_todos);
        // Thu hien thi du lieu co dinh listview
        dataSource = new ArrayList<>();
        dataSource.add(new Todo("1. Đi hoc", true));
        dataSource.add(new Todo("2. Đi chợ"));
        // Hien thi len listview thong qua adapter
        todoAdapter = new TodoAdapter(this, dataSource);
        lvTodos.setAdapter(todoAdapter);


        // Nhan giu den xoa
        lvTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Xoa thanh cong",Toast.LENGTH_SHORT).show();
                dataSource.remove(position);

                return false;
            }
        });
    }

    public void showDialog(View view) {
        // Tao dialog
        if(todoDialog == null){
            todoDialog = new TodoDialog(this) {
                @Override
                public void getTodo(String todo) {
                    dataSource.add(new Todo(todo));
                    todoAdapter.notifyDataSetChanged();
                }
            };
        }

        // Show dialog
        todoDialog.show();

        // Lay du lieu tu dialog

        // Them du lieu vao dataSource

        // Render listview
    }
}