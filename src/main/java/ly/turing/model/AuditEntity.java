package ly.turing.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "audit", indexes = @Index(name = "idx_audit_order_id", columnList = "order_id"))
public class AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id", nullable = false)
    private int auditId;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_on", columnDefinition = "DATETIME", nullable = false)
    private Date createdOn;

    @Column(name = "message", columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(name = "code", nullable = false)
    private int code;
}
