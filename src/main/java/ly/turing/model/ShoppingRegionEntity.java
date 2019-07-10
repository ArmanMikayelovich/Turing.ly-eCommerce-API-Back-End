package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipping_region")
public class ShoppingRegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_region_id", nullable = false)
    private int shippingRegionId;

    @Column(name = "shipping_region", length = 1000, nullable = false)
    private String shippingRegion;
}
