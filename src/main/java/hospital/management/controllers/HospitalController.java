package hospital.management.controllers;

import hospital.management.models.Department;
import hospital.management.models.Hospital;
import hospital.management.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

//    @GetMapping(value = "/{all}")
////    public ResponseEntity<Hospital> getAllStaff(){
////        try{
////            return new ResponseEntity<>(hospitalService.getAllStaff());
////        } catch (Exception e){
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////
////    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        try{
            List<Hospital> hospitals = hospitalService.getAllHospitals();
            return new ResponseEntity<>(hospitals, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping
//    public ResponseEntity<Department> getAllDoctors(){}

}
