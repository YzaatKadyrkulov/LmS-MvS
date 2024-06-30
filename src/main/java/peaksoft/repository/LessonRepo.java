package peaksoft.repository;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonRepo {
    void saveLesson(Long courseId, Lesson lesson);
    List<Lesson> getAllLesson(Long courseId);
    Lesson getByIdLesson(Long lesId);
    void  updateLesson(Long lesId,Lesson newLesson);
    void deleteLesson(Long lessId);
}
