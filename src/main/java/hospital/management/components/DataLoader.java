package hospital.management.components;

import hospital.management.models.Hospital;
import hospital.management.repositories.DepartmentRepository;
import hospital.management.repositories.DoctorRepository;
import hospital.management.repositories.HospitalRepository;
import hospital.management.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    NurseRepository nurseRepository;


    public DataLoader(){

    }
    @Override
    public void run(ApplicationArguments args) throws Exception{
        Hospital stJohns = new Hospital("StJohns", "London SE25");
        hospitalRepository.save(stJohns);
    }
}
