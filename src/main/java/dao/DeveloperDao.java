package dao;

import models.Developer;
import models.Skill;

import java.util.List;

public interface DeveloperDao {
    void addDeveloper(Developer developer);

    void updateDeveloperById(Developer developer);

    void deleteDeveloperById(Long id);

    Developer getDeveloperById(Long id);

    List<Developer> showAllDevelopers();

    void getAllDevelopersBySkillName(Skill skill);

    void getAllDevelopersBySkillDegree(Skill skill);
}
