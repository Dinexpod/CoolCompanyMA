package services;

import models.Skill;

import java.util.List;
import java.util.Set;

public interface SkillService {
    void addSkill(Skill skill);

    void updateSkillById(Skill skill);

    void deleteSkillById(Long id);

    Skill getSkillById(Long id);

    List<Skill> showAllSkills();
}
