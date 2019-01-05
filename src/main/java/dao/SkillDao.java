package dao;

import models.Skill;

import java.util.Set;

public interface SkillDao {
    void addSkill(Skill skill);

    void updateSkillById(Long id);

    void deleteSkillById(Long id);

    Skill getSkillById(Long id);

    Set<Skill> showAllSkills();
}
