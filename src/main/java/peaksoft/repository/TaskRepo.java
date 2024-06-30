package peaksoft.repository;

import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.List;

public interface TaskRepo {
    void saveTask(Long lessonId, Task task);
    List<Task> getAllTasks(Long lessonId);
   Task getByIdTask(Long taskId);
    void  updateTask(Long taskId,Task newTask);
    void deleteTask(Long taskId);
}
