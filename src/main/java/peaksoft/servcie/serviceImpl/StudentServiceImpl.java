package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepo;
import peaksoft.servcie.StudentService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public String createStudent(Student student, Long groupId) {
        return studentRepo.createStudent(student,groupId );
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepo.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        return studentRepo.updateStudent(studentId, newStudent);
    }

    @Override
    public String deleteStudentById(Long studentId) {
        return studentRepo.deleteStudentById(studentId);
    }

    @Override
    public String assignStudentToGroup(Long studentId, Long groupId) {
        return studentRepo.assignStudentToGroup(studentId, groupId);
    }

    @Override
    public List<Student> getAllByStudentsByCompanyId(Long comId) {
        return studentRepo.getAllByStudentsByCompanyId(comId);
    }

    @Override
    public List<Student> getAllByStudentsByGroupId(Long groupId) {
        return studentRepo.getAllByStudentsByGroupId(groupId);
    }

    @Override
    public List<Student> getAllOnlineStudents() {
        return studentRepo.getAllOnlineStudents();
    }

    @Override
    public List<Student> getAllOfflineStudents() {
        return studentRepo.getAllOfflineStudents();
    }
}
