package mate.academy.services;

import mate.academy.models.Developer;
import mate.academy.models.Skill;

import java.util.List;

public interface DeveloperService {
    void addDeveloper(Developer developer);

    void updateDeveloperById(Developer developer);

    void deleteDeveloperById(Long id);

    Developer getDeveloperById(Long id);

    List<Developer> showAllDevelopers();

    void getAllDevelopersBySkillName(Skill skill);

    void getAllDevelopersBySkillDegree(Skill skill);
}
