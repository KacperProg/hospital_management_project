package hospital.management.services;

import hospital.management.models.Department;
import hospital.management.models.Nurse;
import hospital.management.repositories.DepartmentRepository;
import hospital.management.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    public List<Department> getAllDepartaments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartamentById(long id) {
        return departmentRepository.findById(id);
    }


    public List<Department> addNewDepartment(Department department) {
        Department addDepartment = new Department(department.getName());
        departmentRepository.save(addDepartment);
        return null;
    }

    @Transactional
    public Department addNurseToDepartment(Long department_id, Nurse nurse) {
        Department department = departmentRepository.findById(department_id).get();
        if (departmentRepository.findById(department_id).isEmpty()) {
            return null;
        } else {
            department.addNursesToDepartment(nurse);
            departmentRepository.save(department);
        }
        return department;
    }
} //Last Bracket
