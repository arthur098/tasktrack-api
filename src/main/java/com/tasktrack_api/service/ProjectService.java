package com.tasktrack_api.service;

import com.tasktrack_api.model.Project;
import com.tasktrack_api.model.User;
import com.tasktrack_api.model.dto.ProjectRequest;
import com.tasktrack_api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> findAll() {
        return this.repository.findAll();
    }

    public void createProject(ProjectRequest projectReq, User user) {
        this.repository.save(Project.builder()
                .title(projectReq.title())
                .description(projectReq.description())
                .createdAt(LocalDateTime.now())
                .category(projectReq.category())
                .user(user)
                .build());
    }
}
