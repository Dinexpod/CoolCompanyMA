package dao;

import models.Developer;

import java.sql.Connection;
import java.util.Set;

public class DeveloperDaoImpl extends AbstractDao implements DeveloperDao {
    public DeveloperDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addDeveloper(Developer developer) {

    }

    @Override
    public void updateDeveloperById(Long id) {

    }

    @Override
    public void deleteDeveloperById(Long id) {

    }

    @Override
    public Developer getDeveloperById(Long id) {
        return null;
    }

    @Override
    public Set<Developer> showAllDevelopers() {
        return null;
    }
}
