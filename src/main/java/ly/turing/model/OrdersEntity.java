package ly.turing.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders", indexes = {
        @Index(name = "idx_orders_customer_id", columnList = "customer_id"),
        @Index(name = "idx_orders_shipping_id", columnList = "shipping_id"),
        @Index(name = "idx_orders_tax_id", columnList = "tax_id")})
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "total_amount", columnDefinition = "DECIMAL(10,2)", nullable = false)
    @ColumnDefault("0.00")
    private double totalAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_on", nullable = false)
    private Date createdOn;

    @Column(name = "shipped_on")
    private Date shippedOn;

    @Column(name = "status", nullable = false)
    @ColumnDefault("0")
    private int status;

    @Column(name = "comments")
    private String comments;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "auth_code", length = 50)
    private String authCode;

    @Column(name = "reference", length = 50)
    private String reference;

    @Column(name = "shipping_id")
    private int shippingID;

    @Column(name = "tax_id")
    private int taxId;
}
