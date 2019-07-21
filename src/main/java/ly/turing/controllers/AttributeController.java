package ly.turing.controllers;

import ly.turing.service.AttributeService;
import ly.turing.service.ProductAttributeService;
import ly.turing.util.ErrorObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attributes")
public class AttributeController {
    private final AttributeService attributeService;
    private final ProductAttributeService productAttributeService;

    public AttributeController(AttributeService attributeService, ProductAttributeService productAttributeService) {
        this.attributeService = attributeService;
        this.productAttributeService = productAttributeService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Object getAllAttributes(HttpServletResponse response) {
        return attributeService.getAllAttributesFromDBAndReturnAsDTO();
    }

    @RequestMapping(value = "/{attribute_id}", method = RequestMethod.GET, produces = "application/json")
    public Object getAttributeWithId(@PathVariable String attribute_id, HttpServletResponse response) {
        Object object = attributeService.getAttributeWithIdAndReturnAsDto(attribute_id);
        if (object instanceof ErrorObject) {
            response.setStatus(((ErrorObject) object).getStatus());
        }
        return object;
    }

    @RequestMapping(value = "/values/{attribute_id}", method = RequestMethod.GET, produces = "application/json")
    public Object getAttributeValuesWithAttributeId(@PathVariable String attribute_id, HttpServletResponse response) {
        Object object = attributeService.getAttributeValuesListFromDatabaseAsDto(attribute_id);
        if (object instanceof ErrorObject) {
            response.setStatus(((ErrorObject) object).getStatus());
            return object;
        }
        return object;
    }

    @RequestMapping(value = "inProduct/{product_id}", method = RequestMethod.GET, produces = "application/json")
    public Object getAttributesWithProductId(@PathVariable Integer product_id, HttpServletResponse response) {
        return productAttributeService.getAllAttributesWithValuesWithProductId(product_id);
    }
}
