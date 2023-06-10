package com.spring.Energy.controller;

import com.spring.Energy.requestDTO.RegisterDTO;
import com.spring.Energy.responseDTO.StudentsDTO;
import com.spring.Energy.requestDTO.UpdateDTO;
import com.spring.Energy.entity.Student;
import com.spring.Energy.services.StudentRegisterService;
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
    private StudentRegisterService studentRegisterService;

  @PostMapping(value = "/register")
  public Student register(@RequestBody RegisterDTO registerDTO){
      Student a =studentRegisterService.addStudent(registerDTO);
             return a;
    }
    @GetMapping(path = "/getallstudents")
    public List<StudentsDTO> getAllCustomer()
    {
        List<StudentsDTO> recordFile= studentRegisterService.studentDetails();
        return recordFile;
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Student> update(@PathVariable(value ="id") Long studentID,@RequestBody UpdateDTO updateDTO){
        ResponseEntity<Student> upList=studentRegisterService.updateList( studentID,updateDTO);
      return upList;
  }
  @DeleteMapping(path="/delete-student/{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable(value ="id") Long studentID){
      ResponseEntity<HttpStatus>  b= studentRegisterService.deleteStudent(studentID);
     return b;
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> get(@PathVariable Long studentID){
        ResponseEntity<Student> h=studentRegisterService.get(studentID);
        return  h;
    }
    @GetMapping("/search/{name}")
    public List<StudentsDTO> byNameSearch(@PathVariable(value = "name") String name){
      log.info("Student Name ---> {} {}", name);
        List<StudentsDTO>  s =studentRegisterService.byNameSearch(name);
        return s;
    }

}
