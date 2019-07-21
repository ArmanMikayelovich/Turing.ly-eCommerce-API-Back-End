package ly.turing.dto;

import lombok.Data;

@Data
public class ProductEntity {
   int product_id;
    String name;
    String desciption;
    double price;
    double discounted_price;
    String thumbnail;

}
