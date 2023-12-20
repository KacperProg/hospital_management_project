package hospital.management.controllers;

import hospital.management.models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hospital")

public class HospitalController {
//    @Autowired
//    hospital.management.services.HospitalService hospitalService;

//    @GetMapping(value = "/{all}")
////    public ResponseEntity<Hospital> getAllStaff(){
////        try{
////            return new ResponseEntity<>(hospitalService.getAllStaff());
////        } catch (Exception e){
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////
////    }

}
