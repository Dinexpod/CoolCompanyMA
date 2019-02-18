package mate.academy.services;

import mate.academy.models.Skill;

import java.util.List;

public interface SkillService {
    void addSkill(Skill skill);

    void updateSkillById(Skill skill);

    void deleteSkillById(Long id);

    Skill getSkillById(Long id);

    List<Skill> showAllSkills();
}
