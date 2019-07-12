package ly.turing.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "category",
        indexes = @Index(name = "idx_category_department_id"
                , columnList = "department_id"))
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "department_id", nullable = false)
    private int departmentId;

    @Column(name = "name", length = 1000, nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private DepartmentEntity departmentEntity;


}
