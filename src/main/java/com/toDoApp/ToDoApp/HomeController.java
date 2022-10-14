package com.toDoApp.ToDoApp;

import com.toDoApp.ToDoApp.model.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * This class will act as controller to accept the requests and return back the response
 */
@Controller
public class HomeController
{
    // Object of ToDo Repo to get data from table or to update in the table
    @Autowired
    ToDoRepo repo;

    // Main home or welcome page
    @RequestMapping("/")
    public static String home()
    {
        return "Home";
    }

    // JSP which contains the list of ToDo's
    @GetMapping(path = "/list-todos", produces = {"application/json"})
    public String toDoView(Model m)
    {
        // Adding the list of ToDos in toDoList to show in the jsp
        m.addAttribute("todolist", repo.findAll());

        return "ToDoView";
    }

    // Add ToDo View JSP Mapping
    @GetMapping(path = "/add-todo")
    public String addToDoView(Model m)
    {
        return "AddToDo";
    }

    // To Add ToDo in the table
    @PostMapping("/addToDo")
    public String addToDo(ToDoList newToDo)
    {
        // Adding using repo object
        repo.save(newToDo);
        // Redirecting to the list of todos after adding the new todo
        return "redirect:/list-todos";
    }

    // Delete the ToDo from the table using the id which is a primary key of the ToDo list table
    @GetMapping("/delete-todo")
    public String deleteToDo(@RequestParam int id)
    {
        // Getting the ToDo in the object
        List<ToDoList> toDo = repo.findById(id);

        // Checking if the ToDo is there in the table or not
        // If there, then deleting from the table
        if(toDo != null)
        {
            repo.deleteById(id);
        }
        // Redirecting to the list todos after deleting the required todo
        return "redirect:/list-todos";
    }

    // Update ToDo View JSP Mapping
    @GetMapping("/update-todo")
    public String updateToDoView(@RequestParam int id, Model m)
    {
        // Adding the ToDo in the toDo object to show in the JSP
        m.addAttribute("toDo", repo.findById(id));
        // Directing to JSP
        return "UpdateToDo";
    }

    // Updating the ToDo by first deleting the old todo and adding a new one
    // Not a good idea by the way....
    @PostMapping("/updateToDo")
    public String updateToDo(@RequestParam int id, ToDoList newToDo)
    {
        repo.deleteById(id);

        repo.save(newToDo);
        // Redirecting to list-todos after updating to new ToDo
        return "redirect:/list-todos";
    }
}
