package models;

import java.util.Objects;
import java.util.Set;


public class Customer {
    private Long id;
    private String name;
    private int age;
    private Set<Project> projects;

    public void addProject(Project project) {
        projects.add(project);
    }

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                age == customer.age &&
                name.equals(customer.name) &&
                Objects.equals(projects, customer.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, projects);
    }
}
