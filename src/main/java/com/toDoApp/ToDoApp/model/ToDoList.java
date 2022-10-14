package com.toDoApp.ToDoApp.model;

import javax.persistence.*;

/**
 * This class act as table class and id is the primary key and ToDoList is an entity
 */
@Entity
public class ToDoList
{
    // Primary Key of the ToDoList Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Description is the ToDo Description
    private String description;
    // toDoDate is the Target Date of the ToDo
    private String toDoDate;

    // Constructor
    public ToDoList()
    {
        super();
    }

    // Parameterized Constructor
    public ToDoList(String description, String toDoDate)
    {
        super();
        this.description = description;
        this.toDoDate = toDoDate;
    }

    // Getter and Setter Methods Below

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getToDoDate()
    {
        return toDoDate;
    }

    public void setToDoDate(String toDoDate)
    {
        this.toDoDate = toDoDate;
    }

    @Override
    public String toString()
    {
        return "ToDoList{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", toDoDate=" + toDoDate +
                '}';
    }
}
