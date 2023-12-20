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


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnoreProperties({"departments"})
    private Hospital hospital;


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
//    @ManyToMany(mappedBy = "departments")
//    @JsonIgnoreProperties({"departments"})

//    @ManyToMany(mappedBy = "departments")
//    @JsonIgnoreProperties({"departments"})


    public Department(String name) {
        this.name = name;
        this.nurses = new ArrayList<>();
        this.doctors = new ArrayList<>();
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

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
