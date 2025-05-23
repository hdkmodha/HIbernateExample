package org.example;

import jakarta.persistence.*;

import javax.xml.namespace.QName;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Column(name = "e_id")
    @Id private  long id;
    @Column(name = "e_name")
    private String name;
    @Column(name = "e_department")
    private String department;
    @Column(name = "e_laptop")
    @OneToMany(mappedBy = "employee")
    private List<Laptop> laptops;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
