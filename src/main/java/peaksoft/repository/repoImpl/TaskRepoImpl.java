package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class TaskRepoImpl implements TaskRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveTask(Long lessonId, Task task) {
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        lesson.getTasks().add(task);
        task.setLesson(lesson);
        entityManager.persist(task);
    }

    @Override
    public List<Task> getAllTasks(Long lessonId) {
        return entityManager.createQuery("select t from Task  t where t.lesson.id=:id", Task.class).setParameter("id", lessonId).getResultList();
    }

    @Override
    public Task getByIdTask(Long taskId) {
        return entityManager.find(Task.class, taskId);
    }

    @Override
    public void updateTask(Long taskId, Task newTask) {
        Task task = getByIdTask(taskId);
        task.setTaskName(newTask.getTaskName());
        task.setTaskText(newTask.getTaskText());
        task.setDeadline(newTask.getDeadline());
        entityManager.merge(task);


    }

    @Override
    public void deleteTask(Long taskId) {
        entityManager.remove(getByIdTask(taskId));
    }
}
