package services;

import models.Developer;

import java.util.Set;

public interface DeveloperService {
    void addDeveloper(Developer developer);

    void updateDeveloperById(Developer developer);

    void deleteDeveloperById(Long id);

    Developer getDeveloperById(Long id);

    Set<Developer> showAllDevelopers();
}
