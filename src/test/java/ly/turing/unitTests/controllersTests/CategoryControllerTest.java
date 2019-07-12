package ly.turing.unitTests.controllersTests;


import ly.turing.controllers.CategoryController;
import ly.turing.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryControllerTest {

    private CategoryController categoryController;

    @Before
    public void before() {
        categoryController = new CategoryController(categoryService);
    }

    @Mock
    CategoryService categoryService;

    @Test
    public void testGet() {
        categoryController.getAllCategories();
        Mockito.verify(categoryService, Mockito.times(1)).getAllCategories();
    }

}