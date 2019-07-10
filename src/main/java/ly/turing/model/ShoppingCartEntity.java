package ly.turing.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "shopping_cart", indexes = @Index(name = "idx_shopping_cart_cart_id",
        columnList = "cart_id"))
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private int itemId;

    @Column(name = "cart_id", columnDefinition = "CHAR(32)")
    private char cartId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "attributes", length = 1000, nullable = false)
    private String attributes;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "buy_now", columnDefinition = "BIT", nullable = false)
    @ColumnDefault("true")
    private boolean buyNow;

    @Column(name = "added_on", columnDefinition = "DATETIME", nullable = false)
    private Date addedOn;
}
