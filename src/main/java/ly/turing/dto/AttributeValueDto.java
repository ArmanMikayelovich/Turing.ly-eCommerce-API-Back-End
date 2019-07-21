package ly.turing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ly.turing.model.AttributeValueEntity;

@Data
@AllArgsConstructor
public class AttributeValueDto {
    int attribute_value_id;
    String value;

    public AttributeValueDto(AttributeValueEntity entity) {
        this.attribute_value_id = entity.getAttributeValueId();
        this.value = entity.getValue();
    }
}
