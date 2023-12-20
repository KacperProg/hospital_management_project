package hospital.management.services;

import hospital.management.models.Department;
import hospital.management.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




}
