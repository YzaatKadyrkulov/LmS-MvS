package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepo;
import peaksoft.servcie.LessonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepo lessonRepo;

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        lessonRepo.saveLesson(courseId, lesson);
    }

    @Override
    public List<Lesson> getAllLesson(Long courseId) {
        return lessonRepo.getAllLesson(courseId);
    }

    @Override
    public Lesson getByIdLesson(Long lesId) {
        return lessonRepo.getByIdLesson(lesId);
    }

    @Override
    public void updateLesson(Long lesId, Lesson newLesson) {
        lessonRepo.updateLesson(lesId, newLesson);
    }

    @Override
    public void deleteLesson(Long lessId) {
        lessonRepo.deleteLesson(lessId);
    }
}
