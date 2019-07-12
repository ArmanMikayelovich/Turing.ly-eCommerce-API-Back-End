package ly.turing.service;

import ly.turing.dto.DepartmentDto;
import ly.turing.model.DepartmentEntity;
import ly.turing.repository.DepartmentRepository;
import ly.turing.util.ErrorObject;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Object getAllDepartments() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        return departmentEntityList.stream().
                map(DepartmentDto::new).collect(Collectors.toList());

    }

    /**
     * @param department_id stanum enq sa yev pordzum gtnel DB-um
     * @return ete DB-um veradarcnum enq department Entity
     * hakarak depqum veradarcnum enq hamapatasxan errorObject
     */
    public Object findDepartmentWithId(String department_id) {
        try {
            int parsedId = Integer.parseInt(department_id);
            Optional<DepartmentEntity> departmentEntityOptional = departmentRepository.findById(parsedId);

            return departmentEntityOptional.orElseThrow(EntityNotFoundException::new);
        } catch (NumberFormatException ex) {
            return new ErrorObject.Builder()
                    .setStatus(400)
                    .setField("department")
                    .setCode("DEP_01")
                    .setMessage("The ID is not a number")
                    .get();
        } catch (EntityNotFoundException ex) {
            return new ErrorObject.Builder()
                    .setStatus(400)
                    .setField("department")
                    .setCode("DEP_02")
                    .setMessage("Don't exist department with this ID")
                    .get();
        }

    }

    public Object findByIdAndGetDto(String department_id) {
        Object object = findDepartmentWithId(department_id);
        if (object instanceof ErrorObject) {
            return object;
        } else return new DepartmentDto((DepartmentEntity) object);
    }
}
