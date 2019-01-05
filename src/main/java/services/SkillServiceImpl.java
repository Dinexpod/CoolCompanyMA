package services;

import dao.SkillDao;
import models.Skill;

import java.util.List;
import java.util.Set;

public class SkillServiceImpl implements SkillService {
    private final SkillDao skillDao;

    public SkillServiceImpl(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public void addSkill(Skill skill) {
        this.skillDao.addSkill(skill);
    }

    @Override
    public void updateSkillById(Skill skill) {
        this.skillDao.updateSkillById(skill);
    }

    @Override
    public void deleteSkillById(Long id) {
        this.skillDao.deleteSkillById(id);
    }

    @Override
    public Skill getSkillById(Long id) {
        return this.skillDao.getSkillById(id);
    }

    @Override
    public List<Skill> showAllSkills() {
        return this.skillDao.showAllSkills();
    }
}
