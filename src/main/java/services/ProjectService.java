package services;

import models.Developer;
import models.Project;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    void addProject(Project project);

    void updateProjectById(Project project);

    void deleteProjectById(Long id);

    Project getProjectById(Long id);

    List<Project> showAllProjects();

    Double getAllSalaryFromProject(Project project);

    void getAllDevelopersFromProject(Project project);
}
