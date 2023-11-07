package com.arjuncodes.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.lang.Object.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class studentService {

    private final studentRepository StR;
    
    @Autowired
    public studentService(studentRepository StR){
        this.StR = StR;
    }

    public List<student> getStudents(){
        return this.StR.findAll();
    }

    public void addNewStudent(student std){
        Optional<student> studentByEmail = StR.findStudentByEmail(std.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        StR.save(std);
    }
    public void deleteStudent(Integer id){
        boolean exist= StR.existsById(id);
        if(!exist){
            throw new IllegalStateException("student not exist");
        }
        StR.deleteById(id);
    }
    @Transactional
    public void updateStudent(Integer id,String name,String email){
        student stu = StR.findById(id).orElseThrow(() -> new IllegalStateException("student not exist"));
        if(name != null && name.length()!= 0){
            stu.setName(name);
        }
        if(email != null && email.length() != 0){
            stu.setEmail(email);
        }
        StR.save(stu);
    }
}
