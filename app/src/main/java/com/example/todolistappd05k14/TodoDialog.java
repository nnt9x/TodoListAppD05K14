package com.example.todolistappd05k14;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public abstract class TodoDialog extends Dialog {

    private Button btnCancel, btnYes;
    private EditText edtTodo;

    public abstract void getTodo(String todo);

    public TodoDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        edtTodo.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_todo);
        btnYes = findViewById(R.id.btn_dialog_yes);
        btnCancel = findViewById(R.id.btn_dialog_cancel);
        edtTodo = findViewById(R.id.edt_dialog_todo);
        // Bat su kien onclick
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay du lieu tu edittext -> chuyen ve activity
                String todo = edtTodo.getText().toString();
                getTodo(todo);
                dismiss();
            }
        });



    }
}
