package ly.turing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ly.turing.model.AttributeEntity;

@Data
@AllArgsConstructor
public class AttributeDto {
    private int attribute_id;
    private String name;

    public AttributeDto(AttributeEntity entity) {
        this.attribute_id = entity.getAttributeId();
        this.name = entity.getName();
    }
}
