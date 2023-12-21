package hospital.management.controllers;

import hospital.management.models.Doctor;
import hospital.management.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //Get doctor by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable Long id){
        try{
            //Create an empty list
            Optional<Doctor> getDoctorById = doctorService.getDoctorById(id);
            if (getDoctorById.isPresent()){
                return new ResponseEntity<>(getDoctorById, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

} //Last
