package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_attribute")
public class ProductAttributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private int productId;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_value_id", nullable = false)
    private int attributeValueId;
}
