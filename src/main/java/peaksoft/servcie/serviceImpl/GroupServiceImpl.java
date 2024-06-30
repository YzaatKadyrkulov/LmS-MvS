package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Group;
import peaksoft.repository.GroupRepo;
import peaksoft.servcie.GroupService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;

    @Override
    public String createGroup(Group group, List<Long> coursesId) {
        return groupRepo.createGroup(group, coursesId);
    }

    @Override
    public String addCourseToGroup(Long groupId, Long courseId) {
        return groupRepo.addCourseToGroup(groupId, courseId);
    }

    @Override
    public Group getGroupById(Long groupId) {
        return groupRepo.getGroupById(groupId);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepo.getAllGroups();
    }

    @Override
    public List<Group> getGroupsByCompanyId(Long companyId) {
        return groupRepo.getGroupsByCompanyId(companyId);
    }

    @Override
    public String updateGroup(Long groupId, Group newGroup) {
        return groupRepo.updateGroup(groupId, newGroup);
    }

    @Override
    public String deleteGroupById(Long groupId) {
        return groupRepo.deleteGroupById(groupId);
    }
}
