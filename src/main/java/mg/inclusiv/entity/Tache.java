package mg.inclusiv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Struct;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    String description;
    boolean status;
    Long utilisateurid;
}
