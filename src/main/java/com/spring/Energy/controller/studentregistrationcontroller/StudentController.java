package com.spring.Energy.controller.studentregistrationcontroller;

import com.spring.Energy.dto.registrationDTO.RegisterDTO;
import com.spring.Energy.dto.registrationDTO.StudentsDTO;
import com.spring.Energy.dto.registrationDTO.UpdateDTO;
import com.spring.Energy.entity.Student;
import com.spring.Energy.services.studentregservice.Studentregisterservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@Slf4j
public class StudentController {
    @Autowired
    private Studentregisterservice services;

  @PostMapping(value = "/register")
  public Student register(@RequestBody RegisterDTO registerDTO){
      Student a =services.addstudent(registerDTO);
             return a;
    }
    @GetMapping(path = "/getallstudents")
    public List<StudentsDTO> getAllCustomer()
    {
        List<StudentsDTO> recordfile= services.studentdetials();
        return recordfile;
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Student> update(@PathVariable(value ="id") Long studentID,@RequestBody UpdateDTO updateDTO){
        ResponseEntity<Student> uplist=services.updatelist( studentID,updateDTO);
      return uplist;
  }
  @DeleteMapping(path="/delete-student/{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable(value ="id") Long studentID){
      ResponseEntity<HttpStatus>  b= services.deletestudent(studentID);
     return b;
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> get(@PathVariable Long studentID){
        ResponseEntity<Student> h=services.get(studentID);
        return  h;
    }
    @GetMapping("/search/{name}")
    public List<StudentsDTO> bynamesearch(@PathVariable(value = "name") String name){
      log.info("Student Name ---> {} {}", name);
        List<StudentsDTO>  s =services.bynamesearch(name);
        return s;
    }

}
