//package hospital.management.models;
//
//import jakarta.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "doctors")
////public class Doctor {
//    // Properties
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
//    private Long id;
//    @Column
//    private String name;
//    @OneToMany(mappedBy = "doctor")
//    private List<Department> departments;
//
//    // Constructor
//    public Doctor(String name) {
//        this.name = name;
//        this.departments = new ArrayList<>();
//    }
//
//    // Empty constructor
//    public Doctor() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Department> getDepartments() {
//        return departments;
//    }
//
//    public void setDepartments(List<Department> departments) {
//        this.departments = departments;
//    }
//}