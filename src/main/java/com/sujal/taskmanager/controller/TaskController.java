package com.sujal.taskmanager.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujal.taskmanager.entity.Task;
import com.sujal.taskmanager.service.TaskService;

@RestController
@RequestMapping ("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    
    //constructor injection
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    //get:retrieve a task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(
        @PathVariable Long id){
            Task task = taskService.getTaskById(id);
            return ResponseEntity.ok(task);
        }
    
        //3.post: create a new task
        @PostMapping
        public ResponseEntity<Task> createTask(
            @RequestBody Task task){
               Task savedTask = taskService.createTask(task);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedTask); 
            }     
    
            //4.pu update an existing task
           @PutMapping("/{id}") 
           public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task){
                Task updatedTask=taskService.updateTask(id, task);
                return ResponseEntity.ok(updatedTask);
            }

            //delete a task 
            @DeleteMapping("/{id}")
            public ResponseEntity<Void> deleteTask( @PathVariable Long id){
                    taskService.deleteTask(id);
                    return ResponseEntity.noContent().build();
                }
            

}
