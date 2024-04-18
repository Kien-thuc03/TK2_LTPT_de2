package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 * @description
 * @author: nktng,
 * @date:17/04/2024,
 */
@Entity
@Table(name = "positions")
@NamedQueries({
        @NamedQuery(name = "Position.FIND_ALL", query = "SELECT p FROM Position p"),
        @NamedQuery(name = "Position.FIND_BY_NAME_AND_SALARY",
                query = "SELECT p FROM Position p WHERE p.name LIKE CONCAT('%', :name, '%') AND p.salary BETWEEN :salaryFrom AND :salaryTo ORDER BY p.name")
})
public class Position implements Serializable {

    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    @Column(name = "position_id")
    private String id;
    private String name;
    private String description;
    private Double salary;
    private int number;

    //moi quan he 1 nhieu voi candidate
    @OneToMany(mappedBy = "positions")
    private Set<Candidate> candidates;

    //moi quan he 1 nhieu voi Experience
    @OneToMany(mappedBy = "position_id")
    private Set<Experience> experiences;

    public Position() {
    }

    public Position(String id, String name, String description, Double salary, int number) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.number = number;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", number=" + number +
                '}';
    }
}
