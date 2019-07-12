package ly.turing.service;

import ly.turing.dto.AttributeDto;
import ly.turing.model.AttributeEntity;
import ly.turing.repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeService {
    private final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public List<AttributeEntity> getAllAttributesFromDatabase() {
        return attributeRepository.findAll();
    }

    public List<AttributeDto> getAllAttributesFromDBAndReturnAsDTO() {
        return getAllAttributesFromDatabase().stream().map(AttributeDto::new).collect(Collectors.toList());
    }


}
