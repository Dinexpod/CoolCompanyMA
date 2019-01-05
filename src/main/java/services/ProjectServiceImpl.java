package services;

import dao.ProjectDao;
import models.Project;

import java.util.Set;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao;

    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void addProject(Project project) {
        this.projectDao.addProject(project);
    }

    @Override
    public void updateProjectById(Project project) {
        this.projectDao.updateProjectById(project);
    }

    @Override
    public void deleteProjectById(Long id) {
        this.projectDao.deleteProjectById(id);
    }

    @Override
    public Project getProjectById(Long id) {
        return this.projectDao.getProjectById(id);
    }

    @Override
    public Set<Project> showAllProjects() {
        return this.projectDao.showAllProjects();
    }
}
