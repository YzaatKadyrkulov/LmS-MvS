package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.CourseRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CourseRepoImpl implements CourseRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveCourse(Long comId, Course course) {
        Company company = entityManager.find(Company.class, comId);
        company.getCourses().add(course);
        course.setCompany(company);
        entityManager.persist(course);

    }

    @Override
    public List<Course> getAllCourses(Long comId) {
        return entityManager.createQuery("select c from  Course  c where c.company.id=:comId", Course.class)
                .setParameter("comId", comId).getResultList();
    }

    @Override
    public List<Course> getAllCourseByGroupId(Long groupId) {
        return entityManager.createQuery("select c from Course c join c.groups g where g.id=:id",
                Course.class).setParameter("id",groupId).getResultList();
    }


    @Override
    public Course getById(Long courseId) {
        return entityManager.find(Course.class,courseId);
    }

    @Override
    public void updateCourse(Long courseId, Course newCourse) {
        Course course = entityManager.find(Course.class,courseId);
        if (course != null) {
            course.setCourseName(newCourse.getCourseName());
            course.setDateOfStart(newCourse.getDateOfStart());
            course.setDescription(newCourse.getDescription());
            entityManager.merge(course);
        }
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        for (Instructor i : course.getInstructor()){
            if (i.getCourse().getId().equals(courseId)){
                i.setCourse(null);
            }
        }
        course.setInstructor(null);


        entityManager.remove(course);
    }
}
