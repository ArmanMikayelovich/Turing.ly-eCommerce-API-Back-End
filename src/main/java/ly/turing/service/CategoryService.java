package ly.turing.service;

import ly.turing.dto.CategoryDto;
import ly.turing.model.CategoryEntity;
import ly.turing.model.DepartmentEntity;
import ly.turing.model.ProductCategoryEntity;
import ly.turing.repository.CategoryRepository;
import ly.turing.util.ErrorObject;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductCategoryService productCategoryService;
    private final DepartmentService departmentService;

    public CategoryService(CategoryRepository categoryRepository, ProductCategoryService productCategoryService, DepartmentService departmentService) {
        this.categoryRepository = categoryRepository;
        this.productCategoryService = productCategoryService;
        this.departmentService = departmentService;
    }

    public Object getAllCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return categoryEntityList.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    public Object findCategoryWithId(String category_id) {
        try {
            int id = Integer.parseInt(category_id);
            Optional<CategoryEntity> categoryEntityOptional = categoryRepository.findById(id);
            CategoryEntity categoryEntity = categoryEntityOptional.orElseThrow(EntityNotFoundException::new);
            return new CategoryDto(categoryEntity);
        } catch (NumberFormatException numberFormatException) {
            return new ErrorObject.Builder()
                    .setStatus(400)
                    .setField("category_id")
                    .setCode("CAT_02")
                    .setMessage("The ID is not a number")
                    .get();
        } catch (EntityNotFoundException ex) {
            return new ErrorObject.Builder()
                    .setStatus(400)
                    .setField("department_id")
                    .setCode("CAT_01")
                    .setMessage("Don't exist category with this ID")
                    .get();
        }
    }

    public Object getCategoriesFromProduct(String product_id) {
        try {
            int productId = Integer.parseInt(product_id);
            Object object = productCategoryService.getProductCategoryWithId(productId);
            if (object instanceof ErrorObject) {
                return object;
            } else {
                int categoryId = ((ProductCategoryEntity) object).getCategoryId();
                return new CategoryDto(categoryRepository.getOne(categoryId));
            }
        } catch (NumberFormatException e) {
            return new ErrorObject.Builder()
                    .setStatus(400)
                    .setField("product_id")
                    .setCode("CAT_02")
                    .setMessage("The ID is not a number")
                    .get();
        }
    }

    public Object getCategoriesFromDepartment(String department_id) {

        Object object = departmentService.findDepartmentWithId(department_id);
        if (object instanceof ErrorObject) {
            return object;
        }
        return ((DepartmentEntity) object).getCategoryEntityList();
    }

    public Object getDtoList(String department_id) {
        Object object = getCategoriesFromDepartment(department_id);
        if (object instanceof ErrorObject) {
            return object;
        }
        return ((List<CategoryEntity>) object).stream().map(CategoryDto::new).collect(Collectors.toList());

    }
}
