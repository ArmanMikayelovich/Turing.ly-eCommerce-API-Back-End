package ly.turing.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer", indexes = {
        @Index(name = "idx_customer_email", columnList = "email", unique = true),
        @Index(name = "idx_customer_shipping_region_id", columnList = "shipping_region_id")
})
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "credit_card", columnDefinition = "TEXT")
    private String creditCard;

    @Column(name = "address_1", length = 100)
    private String addresOne;

    @Column(name = "address_2", length = 100)
    private String addressTwo;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "region", length = 100)
    private String region;

    @Column(name = "postal_code", length = 100)
    private String postalCode;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "shipping_region_id", nullable = false)
    @ColumnDefault("1")
    private int shippingRegionId;

    @Column(name = "day_phone", length = 100)
    private String dayPhone;

    @Column(name = "eve_phone", length = 100)
    private String evePhone;

    @Column(name = "mob_phone", length = 100)
    private String mobNumber;
}
