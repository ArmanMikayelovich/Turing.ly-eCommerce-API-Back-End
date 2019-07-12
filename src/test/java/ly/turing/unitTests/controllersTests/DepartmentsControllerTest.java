package ly.turing.unitTests.controllersTests;

import ly.turing.controllers.DepartmentsController;
import ly.turing.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DepartmentsControllerTest {

    @Mock
    private DepartmentService departmentService;
    @Mock
    HttpServletResponse response;

    private DepartmentsController departmentsController;

    @Before
    public void before() {
        departmentsController = new DepartmentsController(departmentService);
    }

    @Test
    public void getDepartments() {
        departmentsController.getDepartments();
        verify(departmentService, times(1)).getAllDepartments();
    }

    @Test
    public void getOneDepartment() {

        departmentsController.getOneDepartment("asd", response);
        verify(departmentService, times(1)).findByIdAndGetDto(anyString());

    }
}