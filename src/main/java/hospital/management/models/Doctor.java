package hospital.management.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "doctors")
//    @JsonIgnoreProperties({"doctors"})
    private List<Department> departments;

    // Constructor
    public Doctor(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Empty constructor
    public Doctor() {
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
    @ManyToMany(mappedBy = "doctors")
    @JsonIgnoreProperties({"departments"})
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    //method to add/post a doctor to the db
    public void addDepartment(Department department){
        this.departments.add(department);
    }
}