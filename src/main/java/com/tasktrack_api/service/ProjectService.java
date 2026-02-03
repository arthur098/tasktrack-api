package com.tasktrack_api.service;

import com.tasktrack_api.enumerator.EnumProjectCategory;
import com.tasktrack_api.model.Project;
import com.tasktrack_api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public void saveProject() {
        this.repository.deleteAll();
        Project project = new Project();
        project.setTitle("Título");
        project.setDescription("descrição");
        project.setCategory(EnumProjectCategory.STUDY);
        project.setCreatedAt(LocalDateTime.now());
        project.setProgress(0);

        this.repository.save(project);
    }

    public List<Project> findAll() {
        return this.repository.findAll();
    }
}
