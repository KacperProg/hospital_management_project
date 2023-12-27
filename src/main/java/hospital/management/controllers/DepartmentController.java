package hospital.management.controllers;

import hospital.management.models.Department;
import hospital.management.models.Nurse;
import hospital.management.repositories.DepartmentRepository;
import hospital.management.services.DepartmentService;
import hospital.management.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    NurseService nurseService;

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


    @PostMapping
    public ResponseEntity<List<Department>> createADepartment(@RequestBody Department department){
        try {
           return new ResponseEntity<>(departmentService.addNewDepartment(department),HttpStatus.OK) ;
            }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PatchMapping(value ="/{department_id}")
//    public ResponseEntity<Department> addNursesToDepartment(@PathVariable Long department_id,
//                                                       @RequestBody Nurse nurse) {
//        try {
//            Department department = departmentService.addNurseToDepartment(department_id, nurse);
//            return new ResponseEntity<>(department, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    //Adding all nurses to a department
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Department> updateDepartmentForNurse(@RequestBody Department department, @PathVariable long id){
        try{
            Department updateDepartment = departmentService.updateDepartment(department, id);
            return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Try to add a nurse to a department
    @PostMapping(value = "/{id}/nurses")
    public ResponseEntity<Nurse> addNewNurse(@RequestBody Nurse nurse, @PathVariable long id){
        try {
            Nurse nurseNew = nurseService.addNurse(nurse);
            return new ResponseEntity<>(nurseNew, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }


    @GetMapping(value = "/names")
    public ResponseEntity<List<String>> getDepartmentNames() {
        List<Department> departments = departmentService.getAllDepartaments();
        List<String> departmentNames = new ArrayList<>();
        for (Department department : departments) {
            departmentNames.add(department.getName());
        }
        return new ResponseEntity<>(departmentNames,HttpStatus.OK);
    }

} //Last bracket

