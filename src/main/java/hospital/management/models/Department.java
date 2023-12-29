package hospital.management.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;


    @ManyToMany(mappedBy = "departments")
    @JsonIgnoreProperties({"departments"})
    private List<Hospital> hospitals;


    @ManyToMany
    @JoinTable(name = "department_doctor",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List <Doctor> doctors;

    //This list(field) represents the collection of 'Doctors' entites associated with a 'Department'


    @ManyToMany
    @JoinTable(name = "department_nurse",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "nurse_id"))
    private List <Nurse> nurses;


    public Department(String name) {
        this.name = name;
        this.nurses = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.hospitals = new ArrayList<>();
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addNursesToDepartment(Nurse nurse){ this.nurses.add(nurse);}

    public void addDoctorsToDepartment(Doctor doctor){this.doctors.add(doctor);}
}
