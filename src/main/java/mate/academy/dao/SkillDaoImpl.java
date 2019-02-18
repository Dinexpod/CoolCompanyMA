package mate.academy.dao;

import mate.academy.models.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDao {

    public SkillDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addSkill(Skill skill) {
        final String INSERT = "INSERT INTO skills(degree, name) VALUES(?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, skill.getDegree().name());
            statement.setString(2, skill.getName().name());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSkillById(Skill skill) {
        final String UPDATE =
                "UPDATE skills SET degree=?, name=? WHERE skill_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, skill.getDegree().name());
            statement.setString(2, skill.getName().name());
            statement.setLong(3, skill.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSkillById(Long id) {
        final String DEL = "DELETE FROM skills WHERE skill_id=?";
        final String DEL_FROM_DEVELOPER = "DELETE FROM developers_skills WHERE skill=?";

        try {
            PreparedStatement statement = connection.prepareStatement(DEL);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DEL_FROM_DEVELOPER);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill getSkillById(Long id) {
        final String SELECT = "SELECT * FROM skills WHERE skill_id = " + id + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);

            return rs.next() ? getSkill(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Skill getSkill(ResultSet rs) throws SQLException {
        Skill skill = new Skill();
        skill.setId(rs.getLong("skill_id"));
        Skill.Degree.valueOf(rs.getString("degree"));
        Skill.Name.valueOf(rs.getString("name"));

        return skill;
    }

    @Override
    public List<Skill> showAllSkills() {
        final String FIND_ALL = "SELECT * FROM skills";

        List<Skill> skills = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Skill skill = getSkill(rs);
                skills.add(skill);
            }

            return skills;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skills;
    }
}
