package dao;

import models.Project;

import java.util.List;

public interface ProjectDao {
    void addProject(Project project);

    void updateProjectById(Project project);

    void deleteProjectById(Long id);

    Project getProjectById(Long id);

    List<Project> showAllProjects();

    Double getAllSalaryFromProject(Project project);

    void getAllDevelopersFromProject(Project project);

    int showSomeDevs();
}
