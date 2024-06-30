package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepo;
import peaksoft.servcie.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    @Override
    public void saveTask(Long lessonId, Task task) {
        taskRepo.saveTask(lessonId, task);
    }

    @Override
    public List<Task> getAllTasks(Long lessonId) {
        return taskRepo.getAllTasks(lessonId);
    }

    @Override
    public Task getByIdTask(Long taskId) {
        return taskRepo.getByIdTask(taskId);
    }

    @Override
    public void updateTask(Long taskId, Task newTask) {
        taskRepo.updateTask(taskId, newTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepo.deleteTask(taskId);
    }
}
