package services;

import dao.DeveloperDao;
import models.Developer;

import java.util.Set;

public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperDao developerDao;

    public DeveloperServiceImpl(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    public void addDeveloper(Developer developer) {
        this.developerDao.addDeveloper(developer);
    }

    @Override
    public void updateDeveloperById(Long id) {
        this.developerDao.updateDeveloperById(id);
    }

    @Override
    public void deleteDeveloperById(Long id) {
        this.developerDao.deleteDeveloperById(id);
    }

    @Override
    public Developer getDeveloperById(Long id) {
        return this.developerDao.getDeveloperById(id);
    }

    @Override
    public Set<Developer> showAllDevelopers() {
        return this.developerDao.showAllDevelopers();
    }
}
