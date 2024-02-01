package bakyt.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_gen", sequenceName = "company_seq", allocationSize = 1)
public class Company extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Project> project ;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    public Company(String name) {
        this.name = name;
    }
}
