package ly.turing.repository;

import ly.turing.model.ProductAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttributeEntity, Integer> {

        @Query(nativeQuery = true,
                value = "SELECT * from product_attribute where product_id = ?1")
        Collection<ProductAttributeEntity> getAllEntitiesFromDatabaseWithProductId(Integer productId);
}
