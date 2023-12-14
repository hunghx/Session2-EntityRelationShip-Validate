package ra.academy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @UuidGenerator
    private  String productId;
    private String productName;
    private BigDecimal price;
    private int stock;
    @Column(columnDefinition = "text")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalogId",foreignKey = @ForeignKey(name = "fk_catalog_id"))
//    @JsonIgnoreProperties({"catalogId"})
    @JsonIgnore
    private Catalog catalog;
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private ProductDetail productDetail;
}
