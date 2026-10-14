package pt.natixis.hello_spring.controller;

import org.springframework.web.bind.annotation.*;
import pt.natixis.hello_spring.model.Task;
import pt.natixis.hello_spring.service.TaskService;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/tasks/done")
    public List<Task> getDoneTasks() {
        return taskService.getTasksAlreadyDone();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task newTask) {
        return taskService.createTask(newTask);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task newTask) {
        return taskService.updateTask(id, newTask);
    }

    @DeleteMapping("/tasks/{id}")
    public boolean deleteTask(@PathVariable Long id) {
        if(taskService.deleteTask(id)){
            return true;
        }else{
            return false;
        }

    }

}
