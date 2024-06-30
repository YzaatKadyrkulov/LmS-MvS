package peaksoft.repository;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentRepo {
    String createStudent(Student student,Long groupId);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    String updateStudent(Long studentId, Student newStudent);

    String deleteStudentById(Long studentId);

    String assignStudentToGroup(Long studentId, Long groupId);
    List<Student> getAllByStudentsByCompanyId(Long comId);
    List<Student> getAllByStudentsByGroupId(Long groupId);
    List<Student> getAllOnlineStudents();
    List<Student> getAllOfflineStudents();
}
