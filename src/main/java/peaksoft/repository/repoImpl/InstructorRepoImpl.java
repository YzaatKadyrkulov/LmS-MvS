package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class InstructorRepoImpl implements InstructorRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return entityManager.createQuery("select i from Instructor  i ", Instructor.class).getResultList();
    }

    @Override
    public List<Instructor> getAllInstructorsByCourseId(Long courseId) {
        return entityManager.createQuery("select i from Instructor i  join i.course c where c.id=:id", Instructor.class).setParameter("id", courseId).getResultList();
    }

    @Override
    public List<Instructor> getAllInstructorsByComId(Long comId) {
        return entityManager.createQuery("select i from Instructor i join i.companies c where c.id = :id", Instructor.class)
                .setParameter("id", comId)
                .getResultList();
    }


    @Override
    public void updateInstructor(Long insId, Instructor newInstructor) {
        Instructor instructor = entityManager.find(Instructor.class, insId);
        if (instructor != null) {
            instructor.setFirstName(newInstructor.getFirstName());
            instructor.setLastName(newInstructor.getLastName());
            instructor.setSpecialization(newInstructor.getSpecialization());
            entityManager.merge(instructor);
        }

    }

    @Override
    public void deleteById(Long insId) {
        entityManager.remove(entityManager.find(Instructor.class, insId));
    }

    @Override
    public void assignInstructorToCompany(List<Long> insId, Long comId) {
        Company company = entityManager.find(Company.class, comId);
        for (Long inId:insId){
            Instructor instructor = entityManager.find(Instructor.class, inId);
            if (instructor!=null){
                company.getInstructors().add(instructor);
                instructor.getCompanies().add(company);
                entityManager.merge(instructor);
            }
        }
        entityManager.merge(company);
    }

    @Override
    public void addInstructorToCourse(Long insId, Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        Instructor instructor = entityManager.find(Instructor.class, insId);
        course.getInstructor().add(instructor);
        instructor.setCourse(course);
        entityManager.merge(instructor);
        entityManager.merge(course);
    }

    @Override
    public void deleteInstructorFromCompany(Long insId, Long comId) {
        Instructor instructor = getInstructorById(insId);
        Company company = entityManager.find(Company.class, comId);
        company.getInstructors().removeIf
                (instructor1 -> instructor1.getId().equals(insId));
        instructor.getCompanies().removeIf(company1 -> company1.getId().equals(comId));
        entityManager.merge(company);
        entityManager.merge(instructor);
    }
}