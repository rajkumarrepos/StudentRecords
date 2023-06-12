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
      Student registerObject =studentRegisterService.addStudent(registerDTO);
             return registerObject;
    }
    @GetMapping(path = "/get")
    public List<StudentsDTO> getAllCustomer()
    {
        List<StudentsDTO> recordFile= studentRegisterService.studentDetails();
        return recordFile;
    }
    @PutMapping(value = "/update/{rollNo}")
    public ResponseEntity<Student> update(@PathVariable(value ="rollNo") Long studentRollNo,@RequestBody UpdateDTO updateDTO){
        ResponseEntity<Student> upList=studentRegisterService.updateList( studentRollNo,updateDTO);
      return upList;
  }
  @DeleteMapping(path="/{rollNo}")
  public ResponseEntity<HttpStatus> delete(@PathVariable(value ="rollNo") Long studentRollNo){
      ResponseEntity<HttpStatus>  deletedStudent= studentRegisterService.deleteStudent(studentRollNo);
     return deletedStudent;
    }
    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> get(@PathVariable(value ="rollNo") Long studentRollNo){
        ResponseEntity<Student> studentResponseEntity =studentRegisterService.get(studentRollNo);
        return  studentResponseEntity;
    }
    @GetMapping("/search/{name}")
    public List<StudentsDTO> byNameSearch(@PathVariable(value = "name") String name){
      log.info("Student Name ---> {} {}", name);
        List<StudentsDTO>  studentList =studentRegisterService.byNameSearch(name);
        return studentList;
    }

}
