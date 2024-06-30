package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class LessonRepoImpl implements LessonRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        Course course = entityManager.find(Course.class, courseId);
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        entityManager.persist(lesson);

    }

    @Override
    public List<Lesson> getAllLesson(Long courseId) {
        return entityManager.createQuery("select l from Lesson l where l.course.id=:id", Lesson.class).setParameter("id", courseId).getResultList();
    }

    @Override
    public Lesson getByIdLesson(Long lesId) {
        return entityManager.find(Lesson.class,lesId);
//        Course course = entityManager.find(Course.class, courseId);
//        try {
//            for (Lesson lesson : course.getLessons()) {
//                if (lesson.getId().equals(lesId)) {
//                    return lesson;
//                }
//            }
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
    }

    @Override
    public void updateLesson(Long lesId, Lesson newLesson) {
        Lesson lesson = getByIdLesson(lesId);
        if (lesson != null) {
            lesson.setLessonName(newLesson.getLessonName());
        } else {
            throw new RuntimeException("lesson not found");
        }
    }

    @Override
    public void deleteLesson(Long lessId) {
       Lesson lesson= getByIdLesson(lessId);
//        Course course = lesson.getCourse();
////        for (Lesson lesson1 :course.getLessons()){
////            if (lesson1.getId().equals(lessId)){
////               course.getLessons().remove(lesson1);
////            }
////        }
        lesson.setCourse(null);
        entityManager.remove(lesson);
    }
}
