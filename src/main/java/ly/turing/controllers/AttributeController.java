package ly.turing.controllers;

import ly.turing.service.AttributeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attributes")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Object getAllAttributes(HttpServletResponse response) {
        return attributeService.getAllAttributesFromDBAndReturnAsDTO();
    }
}
