package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @description
 * @author: nktng,
 * @date:17/04/2024,
 */
@Entity
@Table(name = "experiences")
@NamedQueries({
        @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e"),
        @NamedQuery(name = "Experience.findByCompanyName", query = "SELECT e FROM Experience e WHERE e.companyName = :companyName"),
        @NamedQuery(name = "Candidate.FIND_WITH_LONGEST_EXPERIENCE",
            query = "SELECT c, MAX(e.toDate - e.fromDate) FROM Candidate c JOIN c.experiences e GROUP BY c.id")

})
public class Experience implements Serializable {
    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    private String description;

    //moi quan he nhieu mot voi Candidate
    @ManyToOne
//    @JoinTable(name = "experiences",
//            joinColumns = @JoinColumn(name = "company_name"),
//            inverseJoinColumns = @JoinColumn(name = "candidate_id")
//    )
    @JoinColumn (name = "candidate_id")
    private Candidate candidate_id;

    //moi quan he nhieu mot voi Position
    @ManyToOne
//    @JoinTable(name = "experiences",
//            joinColumns = @JoinColumn(name = "company_name"),
//            inverseJoinColumns = @JoinColumn(name = "position_id"))
    @JoinColumn(name = "position_id")
    private Position position_id;


    public Experience() {
    }

    public Experience(String companyName, LocalDate fromDate, LocalDate toDate, String description) {
        this.companyName = companyName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", description='" + description + '\'' +
                '}';
    }
}
