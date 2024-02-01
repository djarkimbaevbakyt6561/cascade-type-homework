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
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    @ManyToMany(mappedBy = "programmers", cascade = CascadeType.PERSIST)
    private List<Project> projects;
}
