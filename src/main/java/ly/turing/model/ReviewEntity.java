package ly.turing.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "review", indexes = {
        @Index(name = "idx_review_customer_id", columnList = "customer_id"),
        @Index(name = "idx_review_product_id", columnList = "product_id")})
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private int reviewId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "review", columnDefinition = "TEXT", nullable = false)
    private String review;

    @Column(name = "rating", columnDefinition = "SMALLINT", nullable = false)
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_on", nullable = false)
    private Date createdOn;
}
