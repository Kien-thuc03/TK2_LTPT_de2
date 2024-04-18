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
@Table(name = "Candidates")
@NamedQueries(
        {
                @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
                @NamedQuery(name = "Candidate.findByFullName", query = "SELECT c FROM Candidate c WHERE c.fullName = :fullName"),
                @NamedQuery(name = "Candidate.FIND_WITH_EXPERIENCE_COUNT",
            query = "SELECT c.id, COUNT(DISTINCT e.companyName) FROM Candidate c JOIN c.experiences e GROUP BY c.id")
        }
)
public class Candidate implements Serializable {

    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    @Column(name = "candidate_id")
    private String id;
    private String description;
    private String email;
    @Column(name = "full_name")
    private String fullName;
    private String gender;
    private String phone;
    @Column(name = "year_of_birth")
    private int yearOfBirth;

//    moi quan he nhieu mot voi Position
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position positions;

    //    moi quan he mot nhieu voi Experience
    @OneToMany(mappedBy = "candidate_id")
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "candidate_id")
    private Set<Certificate> certificates;


    public Candidate() {
    }

    public Candidate(String id, String description, String email, String fullName, String gender, String phone, int yearOfBirth) {
        this.id = id;
        this.description = description;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
