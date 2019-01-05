package dao;

import models.Project;

import java.util.Set;

public interface ProjectDao {
    void addProject(Project project);

    void updateProjectById(Long id);

    void deleteProjectById(Long id);

    Project getProjectById(Long id);

    Set<Project> showAllProjects();
}
