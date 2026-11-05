package com.sujal.taskmanager.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sujal.taskmanager.entity.Task;
import com.sujal.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    //constructor injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //get task by id
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found with ID" + id)
    );
    }

    //create task
    public Task createTask(Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    //update task
    public Task updateTask(Long id,Task updatedTask){
        Task existingTask=getTaskById(id);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
return taskRepository.save(existingTask);
    }

    //Delete task
    public void deleteTask(Long id){
        Task existingTask=getTaskById(id);
        taskRepository.delete(existingTask);
    }

}
