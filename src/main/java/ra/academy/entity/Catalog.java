package ra.academy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data // bao gồm @Getter, @Setter, @RequiredArgsConstructor, @ToString và HashCode ,Value
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long catalogId;
    private String catalogName;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "catalog",cascade = CascadeType.REMOVE)
//    @JsonIgnore
    private List<Product> products;
}
