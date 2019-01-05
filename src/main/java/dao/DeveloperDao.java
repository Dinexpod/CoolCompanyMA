package dao;

import models.Developer;

import java.util.Set;

public interface DeveloperDao {
    void addDeveloper(Developer developer);

    void updateDeveloperById(Long id);

    void deleteDeveloperById(Long id);

    Developer getDeveloperById(Long id);

    Set<Developer> showAllDevelopers();
}
