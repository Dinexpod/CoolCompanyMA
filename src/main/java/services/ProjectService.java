package services;

import models.Project;

import java.util.Set;

public interface ProjectService {
    void addProject(Project project);

    void updateProjectById(Project project);

    void deleteProjectById(Long id);

    Project getProjectById(Long id);

    Set<Project> showAllProjects();
}
