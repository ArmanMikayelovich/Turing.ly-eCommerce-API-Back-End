package ly.turing.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipping",indexes = @Index(name ="idx_shipping_shipping_region_id",
columnList = "shipping_region_id"))
public class ShippingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id", nullable = false)
    private int shippingId;

    @Column(name = "shipping_type", length = 100, nullable = false)
    private String shippingType;

    @Column(name = "shipping_cost", columnDefinition = "DECIMAL", nullable = false)
    private double shippingCost;

    @Column(name = "shipping_region_id", nullable = false)
    private int shippingRegionId;

}
