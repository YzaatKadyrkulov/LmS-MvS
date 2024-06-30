package peaksoft.servcie;

import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {
    String createGroup(Group group,List<Long> coursesId);

    String addCourseToGroup(Long groupId, Long courseId);

    Group getGroupById(Long groupId);

    List<Group> getAllGroups();

    List<Group> getGroupsByCompanyId(Long companyId);

    String updateGroup(Long groupId, Group newGroup);

    String deleteGroupById(Long groupId);
}
