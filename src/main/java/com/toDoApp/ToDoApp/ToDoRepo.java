package com.toDoApp.ToDoApp;

import com.toDoApp.ToDoApp.model.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This is used to connect with ToDoList Table and Integer is the data tyoe of the primary key
 */
public interface ToDoRepo extends JpaRepository<ToDoList, Integer>
{
    public List<ToDoList> findById(int id);
}
