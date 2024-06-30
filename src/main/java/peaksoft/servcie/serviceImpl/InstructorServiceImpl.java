package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.CourseRepo;
import peaksoft.repository.InstructorRepo;
import peaksoft.servcie.InstructorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepo instructorRepo;

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepo.saveInstructor(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepo.getInstructorById(id);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.getAllInstructors();
    }

    @Override
    public List<Instructor> getAllInstructorsByCourseId(Long courseId) {
        return instructorRepo.getAllInstructorsByCourseId(courseId);
    }

    @Override
    public void updateInstructor(Long insId, Instructor newInstructor) {
        instructorRepo.updateInstructor(insId, newInstructor);
    }

    @Override
    public void deleteById(Long insId) {
        instructorRepo.deleteById(insId);
    }

    @Override
    public void assignInstructorToCompany(List<Long> insId, Long comId) {
        instructorRepo.assignInstructorToCompany(insId, comId);
    }

    @Override
    public void addInstructorToCourse(Long insId, Long courseId) {
        instructorRepo.addInstructorToCourse(insId, courseId);
    }

    @Override
    public List<Instructor> getAllInstructorsByComId(Long comId) {
        return instructorRepo.getAllInstructorsByComId(comId);
    }

    @Override
    public void deleteInstructorFromCompany(Long insId, Long comId) {
        instructorRepo.deleteInstructorFromCompany(insId, comId);
    }

}