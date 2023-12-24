package hospital.management.services;

import hospital.management.models.Doctor;
import hospital.management.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    //Get doctor by id
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    //Get all doctors
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    //Add a doctor in the database
    public void saveDoctor(Doctor doctor){
        Doctor addDoctor = new Doctor(doctor.getName());
        doctorRepository.save(addDoctor);
    }


} // Last
