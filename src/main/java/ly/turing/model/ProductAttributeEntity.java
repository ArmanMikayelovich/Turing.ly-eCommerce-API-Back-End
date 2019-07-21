package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_attribute")
public class ProductAttributeEntity {

    @Column(name = "product_id", nullable = false)
    private int productId;


@Id
    @Column(name = "attribute_value_id", nullable = false)
    private int attributeValueId;
}
