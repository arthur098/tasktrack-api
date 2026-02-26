package com.tasktrack_api.controller;

import com.tasktrack_api.model.User;
import com.tasktrack_api.model.dto.ProjectRequest;
import com.tasktrack_api.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody @Valid ProjectRequest projectReq,
                                                @AuthenticationPrincipal User user) {
        this.projectService.createProject(projectReq, user);

        return ResponseEntity.ok("");
    }
}
