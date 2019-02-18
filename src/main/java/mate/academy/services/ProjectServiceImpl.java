package mate.academy.services;

import mate.academy.dao.ProjectDao;
import mate.academy.models.Project;

import java.util.List;

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
    public List<Project> showAllProjects() {
        return this.projectDao.showAllProjects();
    }

    @Override
    public Double getAllSalaryFromProject(Project project) {
        return this.projectDao.getAllSalaryFromProject(project);
    }

    @Override
    public void getAllDevelopersFromProject(Project project) {
        this.projectDao.getAllDevelopersFromProject(project);
    }

    @Override
    public int showSomeDevs() {
        return this.projectDao.showSomeDevs();
    }
}
