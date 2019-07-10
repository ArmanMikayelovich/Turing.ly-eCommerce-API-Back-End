package ly.turing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tax")
public class TaxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id", nullable = false)
    private int taxId;

    @Column(name = "tax_type", length = 100, nullable = false)
    private String taxType;

    @Column(name = "tax_percentage", columnDefinition = "DECIMAL", nullable = false)
    private double taxPercentage;
}
