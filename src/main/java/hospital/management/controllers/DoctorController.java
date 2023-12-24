package hospital.management.controllers;

import hospital.management.models.Doctor;
import hospital.management.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Get All doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        try{
            //Create an empty list
            List<Doctor> getAllDoctors = doctorService.getAllDoctors();
            if(getAllDoctors.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(getAllDoctors, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    //Post a doctor in the db
    @PostMapping
    public ResponseEntity<List<Doctor>> getDoctor(@RequestBody Doctor doctor){
        doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.CREATED);
    }

} //Last
