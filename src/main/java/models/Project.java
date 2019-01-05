package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Project {
    private Long id;
    private String name;
    private String type;
    private double cost;
    private Set<Developer> developers;
    private Date date;

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    public Project() {
        this.date = new Date();
    }

    public Project(String name, String type, double cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.date = new Date();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toStringDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return
                "date=" + dateFormat.format(date);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", developers=" + developers +
                ", date=" + date +
                '}';
    }
}
