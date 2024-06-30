package peaksoft.repository;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorRepo {
    void saveInstructor(Instructor instructor);
    Instructor getInstructorById(Long id);
    List<Instructor>getAllInstructors();
    List<Instructor>getAllInstructorsByCourseId(Long courseId);
    List<Instructor>getAllInstructorsByComId(Long comId);
    void updateInstructor(Long insId,Instructor newInstructor);
    void deleteById(Long insId);
    void assignInstructorToCompany(List<Long> insId,Long comId);
    void addInstructorToCourse(Long insId,Long courseId);
    void deleteInstructorFromCompany(Long insId,Long comId);
}
