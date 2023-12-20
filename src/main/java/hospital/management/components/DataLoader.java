package hospital.management.components;

import hospital.management.models.Department;
import hospital.management.models.Doctor;
import hospital.management.models.Hospital;
import hospital.management.models.Nurse;
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
        Hospital kingsCollege = new Hospital("King's College", "London SW9");
        Hospital LSMP = new Hospital("Leeds Student Medical Practice", "Leeds, LS6");
        hospitalRepository.save(kingsCollege);
        hospitalRepository.save(LSMP);

        Department accAndEmerg = new Department("A&E");
        Department mentalHealth = new Department("Mental Health");
        departmentRepository.save(accAndEmerg);
        departmentRepository.save(mentalHealth);

        Doctor house = new Doctor("House MD");
        doctorRepository.save(house);

        Nurse joy = new Nurse("Joy","Top");
        nurseRepository.save(joy);
    }
}
