package owu2018.lec_6_servicesupdate.models;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = {"phoneList"})
//@FieldDefaults(level = AccessLevel.PRIVATE)

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    String email;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "contact")
    List<Phone> phoneList = new ArrayList<>();

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
