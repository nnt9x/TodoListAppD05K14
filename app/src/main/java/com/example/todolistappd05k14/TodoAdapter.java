package com.example.todolistappd05k14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class TodoAdapter extends BaseAdapter {
    private Context context;
    private List<Todo> dataSource;
    private LayoutInflater layoutInflater;

    public TodoAdapter(Context context, List<Todo> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewHolder = layoutInflater.inflate(R.layout.item_todo, parent, false);
        // Bind Id
        SwitchCompat rbStatus = viewHolder.findViewById(R.id.rbtn_item_todo_status);
        TextView tvTodo = viewHolder.findViewById(R.id.tv_item_todo);
        ConstraintLayout todoRootView = viewHolder.findViewById(R.id.item_todo_root_view);
        // Do du lieu vao view
        Todo todo = dataSource.get(position);
        tvTodo.setText(todo.getTodo());
        rbStatus.setChecked(todo.isStatus());

        rbStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                todo.setStatus(isChecked);
                notifyDataSetChanged();
            }
        });

        if(todo.isStatus()) {
            todoRootView.setBackgroundResource(android.R.color.holo_blue_dark);
        }
        else{
            todoRootView.setBackgroundResource(android.R.color.white);
        }

        return viewHolder;
    }
}
