package bakyt.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "addresses")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_gen", sequenceName = "address_seq", allocationSize = 1)
public class Address extends BaseEntity{
    private String country;
    @OneToOne(mappedBy = "address", cascade ={ALL})
    private Programmer programmer;
    public Address(String country) {
        this.country = country;
    }
}
