package ly.turing.controllers;

import ly.turing.model.CategoryEntity;
import ly.turing.repository.CategoryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final CategoryRepository categoryRepository;

    public DepartmentsController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    private List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }
}
