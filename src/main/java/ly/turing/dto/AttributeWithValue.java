package ly.turing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttributeWithValue {
    private String attribute_name;
    private int attribute_value_id;
    private String attribute_value;
}
