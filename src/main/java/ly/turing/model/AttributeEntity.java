package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attribute")
public class AttributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id", nullable = false)
    private int attributeId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
}
