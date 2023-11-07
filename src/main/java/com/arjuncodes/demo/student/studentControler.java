package com.arjuncodes.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class studentControler {
    private final studentService StudentService;

    @Autowired
    public studentControler(studentService StS){
        this.StudentService = StS;
    }

    @GetMapping
	public List<student> getStudents(){
		return StudentService.getStudents();
	}

    @PostMapping
    public void registerNewStudent(@RequestBody student std){
        StudentService.addNewStudent(std);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId")Integer studentId){
        StudentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId")Integer studentId,@RequestBody student std){
        StudentService.updateStudent(studentId,std.getName(),std.getEmail());
    }
}
