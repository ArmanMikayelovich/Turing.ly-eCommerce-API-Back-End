package ly.turing.dto;

import lombok.Data;
import ly.turing.model.CategoryEntity;

@Data
public class CategoryDto {
    private int category_id;
    private String name;
    private String description;
    private int department_id;

    public CategoryDto(CategoryEntity entity) {
        this.category_id = entity.getCategoryId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.department_id = entity.getDepartmentEntity().getDepartmentId();
    }

    public CategoryDto(int category_id, String name, String description, int department_id) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.department_id = department_id;
    }
}
