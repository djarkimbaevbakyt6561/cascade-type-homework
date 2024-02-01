package bakyt.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "programmers")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_gen", sequenceName = "programmer_seq", allocationSize = 1)
public class Programmer extends BaseEntity{
    private String fullName;
    private String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "programmers_projects",
            joinColumns = @JoinColumn(name = "programmer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Programmer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}