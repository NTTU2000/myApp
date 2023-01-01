package com.myapp.dev.serviceImpl;

import com.myapp.dev.exception.NotFoundException;
import com.myapp.dev.model.error.ErrorMessage;
import com.myapp.dev.model.mapping.Group;
import com.myapp.dev.model.request.GroupRequest;
import com.myapp.dev.model.response.GroupResponse;
import com.myapp.dev.repository.GroupRepository;
import com.myapp.dev.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<GroupResponse> findAll() {
        List<Group> groups = groupRepository.findAll();
        List<GroupResponse> model = new ArrayList<>();

        groups.forEach(val -> {
            GroupResponse target = new GroupResponse();
            BeanUtils.copyProperties(val, target);
            model.add(target);
        });
        return model;
    }

    public GroupResponse getById(Long id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (!groupOptional.isPresent()) {
            throw new NotFoundException(String.format(ErrorMessage.NOT_FOUND.getMessage(), "USER_GROUP" ,id));
        }
        GroupResponse model = new GroupResponse();
        BeanUtils.copyProperties(groupOptional.get(), model);
        return model;
    }

    public void createGroup(GroupRequest request) {
        Group group = new Group();
        BeanUtils.copyProperties(request, group);
        groupRepository.saveAndFlush(group);
    }

    public void updateGroup(GroupRequest request, Long id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (!groupOptional.isPresent()) {
            throw new NotFoundException(String.format(ErrorMessage.NOT_FOUND.getMessage(), "USER_GROUP" ,id));
        }
        Group group = groupOptional.get();
        BeanUtils.copyProperties(request, group);
        groupRepository.saveAndFlush(group);
    }

    public void deleteGroup(Long id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (!groupOptional.isPresent()) {
            throw new NotFoundException(String.format(ErrorMessage.NOT_FOUND.getMessage(), "USER_GROUP" ,id));
        }
        groupRepository.deleteById(id);
    }

}
