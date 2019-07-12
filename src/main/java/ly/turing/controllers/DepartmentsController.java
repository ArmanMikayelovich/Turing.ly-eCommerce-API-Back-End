package ly.turing.controllers;

import ly.turing.service.DepartmentService;
import ly.turing.util.ErrorObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Object getDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(value = "/{department_id}",produces = "application/json")
    public Object getOneDepartment(@PathVariable String department_id, HttpServletResponse response) {
        Object object = departmentService.findByIdAndGetDto(department_id);

        if (object instanceof ErrorObject) {
            response.setStatus(((ErrorObject) object).getStatus());
            return object;
        } else {
            return object;
        }
    }

}
