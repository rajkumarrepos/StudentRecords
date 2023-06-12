package com.spring.Energy.services;


import com.spring.Energy.requestDTO.RegisterDTO;
import com.spring.Energy.responseDTO.StudentsDTO;
import com.spring.Energy.requestDTO.UpdateDTO;
import com.spring.Energy.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentRegisterService {

    Student addStudent(RegisterDTO registerDTO);



    List<StudentsDTO> studentDetails();
    ResponseEntity<Student> updateList(Long studentID, UpdateDTO updateDTO);
    ResponseEntity<HttpStatus> deleteStudent(Long studentRollNo);

    ResponseEntity<Student> get(Long studentID);

    List<StudentsDTO> byNameSearch(String name);
}
