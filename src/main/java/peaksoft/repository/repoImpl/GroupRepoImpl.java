package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.repository.GroupRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class GroupRepoImpl implements GroupRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String createGroup(Group group, List<Long> coursesId) {
        // Сначала сохранить сущность Group
        entityManager.persist(group);

        for (Long courseId : coursesId) {
            Course course = entityManager.find(Course.class, courseId);
            if (course != null) {
                group.getCourses().add(course);
                course.getGroups().add(group); // Устанавливаем обратную связь для курса
                entityManager.merge(course);
                entityManager.merge(group);
            }
        }

        return "Group created";
    }

    @Override
    public String addCourseToGroup(Long groupId, Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        Group group = entityManager.find(Group.class, groupId);
        group.getCourses().add(course);
        course.getGroups().add(group);
        entityManager.merge(group);
        return "Course added";
    }

    @Override
    public Group getGroupById(Long groupId) {
        return entityManager.find(Group.class, groupId);
    }

    @Override
    public List<Group> getAllGroups() {
        return entityManager.createQuery("from Group", Group.class).getResultList();
    }

    @Override
    public List<Group> getGroupsByCompanyId(Long companyId) {
        String jpql = "select g from Group g " +
                "join g.courses c " +
                "join c.company co " +
                "where co.id = :companyId";

        TypedQuery<Group> query = entityManager.createQuery(jpql, Group.class);
        query.setParameter("companyId", companyId);
        return query.getResultList();
    }

    @Override
    public String updateGroup(Long groupId, Group newGroup) {
        Group group = entityManager.find(Group.class, groupId);
        group.setGroupName(newGroup.getGroupName());
        group.setDescription(newGroup.getDescription());
        group.setImageLink(newGroup.getImageLink());
        entityManager.merge(group);
        return "Group updated";
    }

    @Override
    public String deleteGroupById(Long groupId) {
        Group group = entityManager.find(Group.class, groupId);
        List<Course> courses = group.getCourses();
        for (Course course : courses){
            course.setGroups(null);
        }
        group.setCourses(null);
        entityManager.remove(group);
        return "Group deleted";
    }


}
