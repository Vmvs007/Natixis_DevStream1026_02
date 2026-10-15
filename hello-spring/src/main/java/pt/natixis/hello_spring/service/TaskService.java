package pt.natixis.hello_spring.service;

import org.springframework.stereotype.Service;
import pt.natixis.hello_spring.model.Task;
import pt.natixis.hello_spring.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksAlreadyDone() {

        List<Task> doneTasks = new ArrayList<>();

        for (Task taskAtual : taskRepository.findAll()) {
            if (taskAtual.isDone()) {
                doneTasks.add(taskAtual);
            }
        }

        return doneTasks;
    }

    public Task createTask(Task newTask){

        if(newTask.getDescription() == null || newTask.getDescription().isEmpty()){
            return null;
        }

        return taskRepository.save(newTask);
    }

    public Task updateTask(Long id, Task updatedTask){
        Task existing = taskRepository.findById(id).orElse(null);

        if(existing==null){
            return null;
        }

        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    public boolean deleteTask(Long id){
        Task existing = taskRepository.findById(id).orElse(null);

        if(existing==null){
            return false;
        }

        taskRepository.deleteById(id);
        return true;
    }
}
