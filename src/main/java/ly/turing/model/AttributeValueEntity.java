package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attribute_value",
        indexes = @Index(name = "idx_attribute_value_attribute_id",
                columnList = "attribute_id"))
public class AttributeValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_value_id", nullable = false)
    private int AttributeValueId;

    @Column(name = "attribute_id", nullable = false)
    private int attributeId;

    @Column(name = "value", length = 100)
    private String value;
}
