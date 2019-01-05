package models;

import java.util.Set;

public class Developer {
    private Long id;
    private String name;
    private int age;
    private double salary;
    private Set<Project> projects;
    private Set<Skill> skills;

    public void addProject(Project project) {
        projects.add(project);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public Developer() {
    }

    public Developer(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", projects=" + projects +
                ", skills=" + skills +
                '}';
    }
}
