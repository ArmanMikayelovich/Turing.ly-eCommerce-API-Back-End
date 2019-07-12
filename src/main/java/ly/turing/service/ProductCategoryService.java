package ly.turing.service;

import ly.turing.model.ProductCategoryEntity;
import ly.turing.repository.ProductCategoryRepository;
import ly.turing.util.ErrorObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public Object getProductCategoryWithId(int id) {
        try {
            Optional<ProductCategoryEntity> productCategoryEntityOptional = productCategoryRepository.findById(id);
            return productCategoryEntityOptional.orElseThrow(NullPointerException::new);
        } catch (NullPointerException ex) {
            return new ErrorObject.Builder()
                    .setMessage("Don't exist product_category with this ID")
                    .setCode("PRC_01")
                    .setField("product_id")
                    .setStatus(400).get();
        }
    }
}
