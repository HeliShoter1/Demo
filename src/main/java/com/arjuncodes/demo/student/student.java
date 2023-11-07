package com.arjuncodes.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table
public class student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public student(){}
    public student(String name, String email, LocalDate dob){
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDOB(LocalDate dob){
        this.dob = dob;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public LocalDate getDOB(){
        return this.dob;
    }
    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    @Override
    public String toString(){
        return "student: {" + "id=" + this.id + ", name='" + this.name + "', email='" + this.email  +"', this.dob=" + this.dob + ", age="+ this.age + "}";
    }
}
