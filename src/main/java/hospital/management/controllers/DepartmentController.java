package hospital.management.controllers;

import hospital.management.models.Department;
import hospital.management.repositories.DepartmentRepository;
import hospital.management.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartaments();
        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartamentById(id);
        return new ResponseEntity<Optional<Department>>(department, HttpStatus.OK);
    }

}
