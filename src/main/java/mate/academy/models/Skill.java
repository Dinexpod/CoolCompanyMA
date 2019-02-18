package mate.academy.models;

public class Skill {
    private Long id;
    private Name name;
    private Degree degree;

    public enum Name {
        JAVA,
        RUBY,
        JS,
        PHYTON
    }

    public enum Degree {
        JUNIOR,
        MIDDLE,
        SENIOR
    }

    public Skill() {
    }

    public Skill(Name name, Degree degree) {
        this.name = name;
        this.degree = degree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name=" + name +
                ", degree=" + degree +
                '}';
    }
}
