package dao;

import models.Project;

import java.sql.Connection;
import java.util.Set;

public class ProjectDaoImpl extends AbstractDao implements ProjectDao {
    public ProjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addProject(Project project) {

    }

    @Override
    public void updateProjectById(Long id) {

    }

    @Override
    public void deleteProjectById(Long id) {

    }

    @Override
    public Project getProjectById(Long id) {
        return null;
    }

    @Override
    public Set<Project> showAllProjects() {
        return null;
    }
}
