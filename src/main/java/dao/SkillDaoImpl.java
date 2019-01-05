package dao;

import models.Skill;

import java.sql.Connection;
import java.util.Set;

public class SkillDaoImpl extends AbstractDao implements SkillDao {
    public SkillDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addSkill(Skill skill) {

    }

    @Override
    public void updateSkillById(Skill skill) {

    }

    @Override
    public void deleteSkillById(Long id) {

    }

    @Override
    public Skill getSkillById(Long id) {
        return null;
    }

    @Override
    public Set<Skill> showAllSkills() {
        return null;
    }
}
