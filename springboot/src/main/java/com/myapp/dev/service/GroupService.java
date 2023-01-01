package com.myapp.dev.service;

import com.myapp.dev.model.request.GroupRequest;
import com.myapp.dev.model.response.GroupResponse;

import java.util.List;

public interface GroupService {
    List<GroupResponse> findAll();

    GroupResponse getById(Long id);

    void createGroup(GroupRequest request);

    void updateGroup(GroupRequest request, Long id);

    void deleteGroup(Long id);

}
