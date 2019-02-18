package mate.academy.models;

import java.util.Objects;
import java.util.Set;

public class Company {
    private Long id;
    private String name;
    private Type type;
    private Set<Project> projects;

    public void addProject(Project project) {
        projects.add(project);
    }

    public Company() {
    }

    public Company(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public enum Type {
        INSOURCE,
        OUTSOURCE
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id &&
                name.equals(company.name) &&
                type.equals(company.type) &&
                Objects.equals(projects, company.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, projects);
    }
}
