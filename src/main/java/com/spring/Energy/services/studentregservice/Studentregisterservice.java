package com.spring.Energy.services.studentregservice;


import com.spring.Energy.dto.registrationDTO.RegisterDTO;
import com.spring.Energy.dto.registrationDTO.StudentsDTO;
import com.spring.Energy.dto.registrationDTO.UpdateDTO;
import com.spring.Energy.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Studentregisterservice {
    Student addstudent(RegisterDTO registerDTO);
    List<StudentsDTO> studentdetials();
    ResponseEntity<Student> updatelist(Long studentID, UpdateDTO updateDTO);
    ResponseEntity<HttpStatus> deletestudent(Long studentID);
     ResponseEntity<Student> get(Long id);
     List<StudentsDTO> bynamesearch(String name);
}
