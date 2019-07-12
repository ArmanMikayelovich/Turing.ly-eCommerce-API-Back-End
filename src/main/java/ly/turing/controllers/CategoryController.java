package ly.turing.controllers;

import ly.turing.service.CategoryService;
import ly.turing.util.ErrorObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Object getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/{category_id}", method = RequestMethod.GET, produces = "application/json")
    public Object getOneCategory(@PathVariable String category_id,HttpServletResponse response) {

        Object object = categoryService.findCategoryWithId(category_id);
        if (object instanceof ErrorObject) {
            response.setStatus(((ErrorObject) object).getStatus());
        }
        return object;
    }

    @RequestMapping(value = "/inProduct/{product_id}", method = RequestMethod.GET, produces = "application/json")
    public Object getCategoriesFromProductId(@PathVariable String product_id, HttpServletResponse response) {
        Object object = categoryService.getCategoriesFromProduct(product_id);
        if (object instanceof ErrorObject) {
            response.setStatus(((ErrorObject) object).getStatus());
        }
        return object;
    }

    @RequestMapping(value = "/inDepartment/{department_id}", method = RequestMethod.GET, produces = "application/json")
    public Object getCategoriesFromDepartment(@PathVariable String department_id,HttpServletResponse response) {
        Object object = categoryService.getDtoList(department_id);
        if (object instanceof ErrorObject) {
            response.setStatus(((ErrorObject) object).getStatus());
        }
        return object;
    }


}
