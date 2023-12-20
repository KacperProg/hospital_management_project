package hospital.management.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "nurses")
public class Nurse {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String band;

//    @Column
//    Need to determine routes for this one to many || mappedBy


    @ManyToMany(mappedBy = "nurses")
    @JsonIgnoreProperties({"nurses"})
    private List<Department> departments;


    //Constructor
    public Nurse(String name, String band) {
        this.name = name;
        this.band = band;
        this.departments = new ArrayList<>();
    }

    //Empty construtor
    public Nurse(){
    }

    //Getters and setters


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

    public String getBand() {
        return band;
    }
    public void setBand(String band) {
        this.band = band;
    }

    public List<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }


} //Last
