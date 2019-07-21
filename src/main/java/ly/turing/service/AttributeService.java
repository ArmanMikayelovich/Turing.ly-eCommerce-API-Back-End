package ly.turing.service;

import ly.turing.dto.AttributeDto;
import ly.turing.dto.AttributeValueDto;
import ly.turing.model.AttributeEntity;
import ly.turing.model.AttributeValueEntity;
import ly.turing.repository.AttributeRepository;
import ly.turing.repository.AttributeValueRepository;
import ly.turing.util.ErrorObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttributeService {
    private final AttributeRepository attributeRepository;
    private final AttributeValueRepository attributeValueRepository;

    public AttributeService(AttributeRepository attributeRepository, AttributeValueRepository attributeValueRepository) {
        this.attributeRepository = attributeRepository;
        this.attributeValueRepository = attributeValueRepository;
    }

    public List<AttributeEntity> getAllAttributesFromDatabase() {
        return attributeRepository.findAll();
    }

    public List<AttributeDto> getAllAttributesFromDBAndReturnAsDTO() {
        return getAllAttributesFromDatabase().stream().map(AttributeDto::new).collect(Collectors.toList());
    }

    public Object getAttributeWithId(int id) {
        try {
            Optional<AttributeEntity> attributeEntityOptional = attributeRepository.findById(id);
            return attributeEntityOptional.orElseThrow(NullPointerException::new);
        } catch (NullPointerException ex) {
            return new ErrorObject.Builder()
                    .setStatus(400)
                    .setField("attribute_id")
                    .setCode("ATR_02")
                    .setMessage("Can't find attribute with thid ID : " + id).get();
        }
    }

    public Object getAttributeWithIdAndReturnAsDto(String id) {
        try {
            int attributeId = Integer.parseInt(id);
            Object object = getAttributeWithId(attributeId);
            if (object instanceof ErrorObject) {
                return object;
            }
            return new AttributeDto((AttributeEntity) object);
        } catch (NumberFormatException ex) {
            return new ErrorObject.Builder().
                    setCode("ATR_01")
                    .setField("attribute_id")
                    .setStatus(400)
                    .setMessage("attribute_id is not number : " + id).get();
        }
    }

    public Object getAttributeValuesListFromDatabaseAsDto(String attribute_id) {
        try {
            int attributeId = Integer.parseInt(attribute_id);
            Object object = getAttributeWithId(attributeId);
            if (object instanceof ErrorObject) {
                return object;
            }
            List<AttributeValueEntity> attributeValueEntityList =
                    ((AttributeEntity) object).getAttributeValueEntityList();
            return attributeValueEntityList.stream().map(AttributeValueDto::new).collect(Collectors.toList());
        } catch (NumberFormatException ignored) {
            return new ErrorObject.Builder()
                    .setCode("ATR_02")
                    .setField("attribute_id")
                    .setMessage("attribute_id is not number : " + attribute_id)
                    .setStatus(400).get();
        }
    }

    public List<AttributeValueEntity> getAllAttributesWithId(List<Integer> idList) {
        return idList.stream().map(attributeValueRepository::getOne).collect(Collectors.toList());

    }


}
