package ly.turing.dto;

import lombok.Data;
import ly.turing.model.DepartmentEntity;

@Data
public class DepartmentDto {
    private int department_id;
    private String name;
    private String description;

    public DepartmentDto(DepartmentEntity entity) {
        this.department_id = entity.getDepartmentId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }

    public DepartmentDto(int department_id, String name, String description) {
        this.department_id = department_id;
        this.name = name;
        this.description = description;
    }
}
