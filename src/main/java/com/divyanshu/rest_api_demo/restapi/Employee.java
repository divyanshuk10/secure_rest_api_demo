package com.divyanshu.rest_api_demo.restapi;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Date;

@Entity
@Table(name = "Employee") // This is optional spring will create the table from class name
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotEmpty
    private String name;
    @Column
    @PositiveOrZero
    private float salary;
    @Column
    @NotEmpty
    private String designation;
    @Column
    @PastOrPresent
    private Date joiningDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Employee() {
    }

    public Employee(String name, float salary, String designation, Date joiningDate, Project project) {
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "\n Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", joiningDate=" + joiningDate +
                ", project=" + project +
                '}';
    }
}
