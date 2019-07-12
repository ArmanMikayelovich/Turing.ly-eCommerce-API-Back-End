package ly.turing.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product",
        indexes = @Index(name = "idx_ft_product_name_description",
                columnList = "name, description"))
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @Column(name = "price", columnDefinition = "DECIMAL", nullable = false)
    @ColumnDefault("0.00")
    private double price;


    @Column(name = "thumbnail", length = 150)
    private String thumbnail;

    @Column(name = "display", columnDefinition = "SMALLINT", nullable = false)
    @ColumnDefault("0")
    private int display;

}
