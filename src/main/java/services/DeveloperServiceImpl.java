package services;

import dao.DeveloperDao;
import models.Developer;
import models.Skill;

import java.util.List;

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
    public void updateDeveloperById(Developer developer) {
        this.developerDao.updateDeveloperById(developer);
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
    public List<Developer> showAllDevelopers() {
        return this.developerDao.showAllDevelopers();
    }

    @Override
    public void getAllDevelopersBySkillName(Skill skill) {
        this.developerDao.getAllDevelopersBySkillName(skill);
    }

    @Override
    public void getAllDevelopersBySkillDegree(Skill skill) {
        this.developerDao.getAllDevelopersBySkillDegree(skill);
    }
}
