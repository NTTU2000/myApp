package com.myapp.dev.controller;

import com.myapp.dev.model.request.GroupRequest;
import com.myapp.dev.model.response.GroupResponse;
import com.myapp.dev.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/group")
    public ResponseEntity<List<GroupResponse>> groups() {
        return ResponseEntity.ok().body(groupService.findAll());
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<GroupResponse> getGroup(@PathVariable Long id) {
        return ResponseEntity.ok().body(groupService.getById(id));
    }

    @PostMapping("/group")
    public ResponseEntity<Void> create(@RequestBody GroupRequest request) {
        groupService.createGroup(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<Void> update(@RequestBody GroupRequest request, @PathVariable Long id) {
        groupService.updateGroup(request, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
