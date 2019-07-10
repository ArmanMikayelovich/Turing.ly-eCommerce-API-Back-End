package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_detail", indexes = @Index(name = "idx_order_detail_order_id",
        columnList = "order_id"))
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private int itemId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "attributes", length = 1000, nullable = false)
    private String attributes;

    @Column(name = "product_name", length = 1000, nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_cost", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private int unitCost;

}
