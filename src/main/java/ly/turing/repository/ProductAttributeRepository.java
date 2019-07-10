package ly.turing.repository;

import ly.turing.model.ProductAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttributeEntity,Integer> {
}
