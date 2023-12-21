package hospital.management.controllers;


import hospital.management.models.Nurse;
import hospital.management.repositories.NurseRepository;
import hospital.management.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nurses")
public class NurseController {
    @Autowired
    NurseService nurseService;

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> findByNurseById(@PathVariable Long id){ //method declaration
        try {
            Optional<Nurse> findNurseById = nurseService.findNurseById(id);
            if (findNurseById.isPresent()){
                return new ResponseEntity<>(findNurseById.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      } catch(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    }

    @GetMapping
    public ResponseEntity<List<Nurse>> findAllNurses(){
            try {
                List<Nurse> findAllNurses = nurseService.findAllNurses();
                if (findAllNurses.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                } else {
                    return new ResponseEntity<>(nurseService.findAllNurses(), HttpStatus.OK);
                }
            }   catch(Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }
} //Last braket



