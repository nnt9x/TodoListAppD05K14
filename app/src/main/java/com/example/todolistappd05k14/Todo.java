package com.example.todolistappd05k14;

public class Todo {
    private String todo;
    private boolean status = false;

    public Todo(String todo) {
        this.todo = todo;
    }

    public Todo(String todo, boolean status) {
        this.todo = todo;
        this.status = status;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todo='" + todo + '\'' +
                ", status=" + status +
                '}';
    }
}
