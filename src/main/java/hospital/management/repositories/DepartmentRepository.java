package hospital.management.repositories;

import hospital.management.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department,Long> {
}
