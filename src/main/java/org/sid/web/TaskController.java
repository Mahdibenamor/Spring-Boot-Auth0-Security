package org.sid.web;

import lombok.Data;
import org.sid.entities.AppUser;
import org.sid.entities.Task;
import org.sid.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public Task register(@RequestBody TaskForm taskForm){
        Task task = new Task();
        task.setTaskName(taskForm.getTaskName());
        return  taskService.saveTask(task);
    }

    @GetMapping("/task")
    public List<Task> register(){
        return  taskService.getTask();
    }
}

@Data
class TaskForm{
    private String taskName;
}
