package ly.turing.service;

import ly.turing.dto.AttributeWithValue;
import ly.turing.model.AttributeValueEntity;
import ly.turing.model.ProductAttributeEntity;
import ly.turing.repository.ProductAttributeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributeService {
    private final AttributeService attributeService;
    private final ProductAttributeRepository productAttributeRepository;

    public ProductAttributeService(AttributeService attributeService, ProductAttributeRepository productAttributeRepository) {
        this.attributeService = attributeService;
        this.productAttributeRepository = productAttributeRepository;
    }

    public Object getAllAttributesWithValuesWithProductId(int productId) {
        Collection<ProductAttributeEntity> productAttributeEntityList =
                productAttributeRepository.getAllEntitiesFromDatabaseWithProductId(productId);
        List<Integer> attributeValueIdList = productAttributeEntityList.stream()
                .map(ProductAttributeEntity::getAttributeValueId).collect(Collectors.toList());
        List<AttributeValueEntity> allAttributeValuesWithId = attributeService.getAllAttributesWithId(attributeValueIdList);

        return allAttributeValuesWithId.stream().map(attributeValue -> new AttributeWithValue(
                attributeValue.getAttributeEntity().getName(),
                attributeValue.getAttributeValueId(),
                attributeValue.getValue()
        )).collect(Collectors.toList());
    }
}
