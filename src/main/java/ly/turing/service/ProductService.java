package ly.turing.service;

import ly.turing.model.ProductEntity;
import ly.turing.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductEntity> findAll() {
      return productRepository.findAll();
  }
}
