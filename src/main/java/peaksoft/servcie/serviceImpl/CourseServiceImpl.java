package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepo;
import peaksoft.servcie.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public void saveCourse(Long comId, Course course) {
        courseRepo.saveCourse(comId, course);
    }

    @Override
    public List<Course> getAllCourses(Long ComId) {
        return courseRepo.getAllCourses(ComId);
    }

    @Override
    public List<Course> getAllCourseByGroupId(Long groupId) {
        return courseRepo.getAllCourseByGroupId(groupId);
    }

    @Override
    public Course getById(Long courseId) {
        return courseRepo.getById(courseId);
    }

    @Override
    public void updateCourse(Long courseId, Course newCourse) {
        courseRepo.updateCourse(courseId, newCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepo.deleteCourse(courseId);
    }
}
