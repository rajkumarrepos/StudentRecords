package com.spring.Energy.serviceImpl;

import com.spring.Energy.conversion.Conversions;
import com.spring.Energy.requestDTO.RegisterDTO;
import com.spring.Energy.responseDTO.StudentsDTO;
import com.spring.Energy.requestDTO.UpdateDTO;
import com.spring.Energy.entity.Student;

import com.spring.Energy.exception.ResourceNotFoundException;
import com.spring.Energy.repository.StudentRepo;
import com.spring.Energy.services.StudentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;

@Service
public class StudentRegisterServiceIMPL implements StudentRegisterService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private Conversions conversions;

    @Override
    public Student addStudent(RegisterDTO registerDTO) {


        Student student = new Student();
                student.setStudentRollNo(registerDTO.getStudentRollNo());
                student.setStudentName(registerDTO.getStudentName());
                student.setStudentStd(conversions.conversionOfNum(registerDTO.getStudentStd()));
                student.setStudentId(registerDTO.getMobileNo());
              studentRepo.save(student);
        return student;
    }

    @Override
    public List<StudentsDTO> studentDetails() {
        List<Student> allDetails = studentRepo.findAll();
        List<StudentsDTO> studentRecord = new ArrayList<>();
        for (Student a : allDetails) {
            StudentsDTO studentsDTO = new StudentsDTO(
                    a.getStudentId(),
                    a.getStudentRollNo(),
                    a.getStudentName(),
                    a.getStudentStd(),
                    a.getMobileNo()
            );
            studentRecord.add(studentsDTO);

        }
        return studentRecord;
    }

    @Override
    public ResponseEntity<Student> updateList(Long studentID, UpdateDTO updateDTO) {


        Student upstudent = studentRepo.findById(studentID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " +studentID));

        upstudent.setStudentId(studentID);
        upstudent.setStudentName(updateDTO.getStudentName());
        upstudent.setStudentStd(conversions.conversionOfNum(updateDTO.getStudentStd()));
        upstudent.setMobileNo(updateDTO.getMobileNo());
        studentRepo.save(upstudent);

        return ResponseEntity.ok(upstudent);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteStudent(Long studentID) {

        Student student= studentRepo.findById(studentID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + studentID));
        studentRepo.delete(student);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @Override
    public ResponseEntity<Student> get(Long studentID){
        Student student =studentRepo.findById(studentID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + studentID));;
        return  ResponseEntity.ok(student) ;
    }
    @Override
    public List<StudentsDTO> byNameSearch(String name) {
        List<Student> a = studentRepo.findByStudentName(name);
        List<StudentsDTO> byName = new ArrayList<>();
        for (Student f : a) {
            StudentsDTO studentsDTO = new StudentsDTO(
                    f.getStudentId(),
                    f.getStudentRollNo(),
                    f.getStudentName(),
                    f.getStudentStd(),
                    f.getMobileNo()
            );
            byName.add(studentsDTO);
        }
        return byName;
    }

}