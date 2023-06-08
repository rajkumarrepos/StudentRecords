package com.spring.Energy.services.studentregservice;

import com.spring.Energy.conversion.Conversions;
import com.spring.Energy.dto.registrationDTO.RegisterDTO;
import com.spring.Energy.dto.registrationDTO.StudentsDTO;
import com.spring.Energy.dto.registrationDTO.UpdateDTO;
import com.spring.Energy.entity.Student;

import com.spring.Energy.exception.ResourceNotFoundException;
import com.spring.Energy.repository.studentrepo.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;

@Service
public class Studentregisterserimpl implements Studentregisterservice {
    @Autowired
    private Studentrepo studentrepo;
    @Autowired
    private Conversions conversions;

    @Override
    public Student addstudent(RegisterDTO registerDTO) {

        Student student = new Student(registerDTO.getStudentID(),
                registerDTO.getStudentName(),
                conversions.conversionOfNum(registerDTO.getStudentStd()),
                registerDTO.getMobileNo()
        );
        studentrepo.save(student);
        return student;
    }

    @Override
    public List<StudentsDTO> studentdetials() {
        List<Student> alldetails = studentrepo.findAll();
        List<StudentsDTO> studentrecord = new ArrayList<>();
        for (Student a : alldetails) {
            StudentsDTO studentsDTO = new StudentsDTO(
                    a.getID(),
                    a.getStudentName(),
                    a.getStudentStd(),
                    a.getMobileNo()
            );
            studentrecord.add(studentsDTO);

        }
        return studentrecord;
    }

    @Override
    public ResponseEntity<Student> updatelist(Long studentID, UpdateDTO updateDTO) {
         // String Z = null;// if (studentrepo.existsById(updateDTO.getStudentID())) {
            Student upstudent = studentrepo.findById(studentID)
                            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " +studentID));

            upstudent.setID(studentID);
            upstudent.setStudentName(updateDTO.getStudentName());
            upstudent.setStudentStd(conversions.conversionOfNum(updateDTO.getStudentStd()));
            upstudent.setMobileNo(updateDTO.getMobileNo());
            studentrepo.save(upstudent);
            /* Z = String.valueOf(updateDTO.getStudentID()); */
       // }

        return ResponseEntity.ok(upstudent);
    }

    @Override
    public ResponseEntity<HttpStatus> deletestudent(Long studentID) {

        Student student= studentrepo.findById(studentID)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + studentID));
        studentrepo.delete(student);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @Override
    public ResponseEntity<Student> get(Long studentID){
           Student student =studentrepo.findById(studentID)
                   .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + studentID));;
           return  ResponseEntity.ok(student) ;
    }
    @Override
    public List<StudentsDTO> bynamesearch(String name) {
        List<Student> a = studentrepo.findByStudentName(name);
        List<StudentsDTO> byname = new ArrayList<>();
        for (Student f : a) {
            StudentsDTO studentsDTO = new StudentsDTO(
                    f.getID(),
                    f.getStudentName(),
                    f.getStudentStd(),
                    f.getMobileNo()
            );
            byname.add(studentsDTO);
        }
        return byname;
    }

}