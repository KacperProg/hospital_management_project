package hospital.management.services;

import hospital.management.models.Doctor;
import hospital.management.models.Nurse;
import hospital.management.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    NurseRepository nurseRepository;

    public Optional<Nurse> findNurseById(Long id) {
        return nurseRepository.findById(id);
    }

    public List<Nurse> findAllNurses(){ return nurseRepository.findAll();}

    //Add a doctor in the database
    public void saveNurse(Nurse nurse){
        Nurse addNurse = new Nurse(nurse.getName(), nurse.getBand());
        nurseRepository.save(addNurse);
    }
}
