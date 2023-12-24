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

        Doctor doctor = new Doctor("William");
        Doctor doctor1 = new Doctor("Charles");
        Doctor doctor2 = new Doctor("Rayster");
        Doctor doctor3 = new Doctor("Mehlia");
        Doctor doctor4 = new Doctor("Kacper");
        doctorRepository.save(doctor);
        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);
        doctorRepository.save(doctor4);

        Nurse nurse = new Nurse("Joy","6");
        Nurse nurse1 = new Nurse("Foridha","5");
        Nurse nurse2 = new Nurse("Janet","6");
        Nurse nurse3 = new Nurse("Suzie","5");
        Nurse nurse4 = new Nurse("Justina","7");
        nurseRepository.save(nurse1);
        nurseRepository.save(nurse);
        nurseRepository.save(nurse2);
        nurseRepository.save(nurse3);
        nurseRepository.save(nurse4);
    }
}
