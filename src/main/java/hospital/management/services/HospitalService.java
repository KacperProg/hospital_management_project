package hospital.management.services;

import hospital.management.models.Hospital;
import hospital.management.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

//    public HttpStatusCode getAllStaff() {
//    }

    public List<Hospital> getAllHospitals(){
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> getHospitalById(Long id){
        return hospitalRepository.findById(id);
    }


}

