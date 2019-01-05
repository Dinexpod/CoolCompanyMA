package dao;

import models.Project;

import java.util.List;
import java.util.Set;

public interface ProjectDao {
    void addProject(Project project);

    void updateProjectById(Project project);

    void deleteProjectById(Long id);

    Project getProjectById(Long id);

    List<Project> showAllProjects();
}
