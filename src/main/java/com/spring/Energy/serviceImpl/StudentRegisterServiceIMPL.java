package com.spring.Energy.serviceImpl;

import com.spring.Energy.conversion.Conversion;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.requestDTO.RegisterDTO;
import com.spring.Energy.responseDTO.StudentsDTO;
import com.spring.Energy.requestDTO.UpdateDTO;
import com.spring.Energy.entity.Student;

import com.spring.Energy.exception.ResourceNotFoundException;
import com.spring.Energy.repository.StudentRepo;
import com.spring.Energy.services.StudentRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
@Slf4j
@Service
public class StudentRegisterServiceIMPL implements StudentRegisterService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student addStudent(RegisterDTO registerDTO) {
        StudentsMarks studentsMarks=new StudentsMarks();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

     //   studentsMarks.setStudentRollNo(registerDTO.getMarkAddDTO().getStudentRollNo());

        BeanUtils.copyProperties(registerDTO.getMarkAddDTO(),studentsMarks);
        studentsMarks.setCreatedDateTime(formatDateTime);
        studentsMarks.setTotal(registerDTO.getMarkAddDTO().getTamil()+registerDTO.getMarkAddDTO().getEnglish()+registerDTO.getMarkAddDTO().getMaths()+registerDTO.getMarkAddDTO().getScience()+registerDTO.getMarkAddDTO().getSocial());
        studentsMarks.setStudentStd(Conversion.conversionOfNum(registerDTO.getMarkAddDTO().getStudentStd()));



        Student student = new Student();
                student.setStudentRollNo(registerDTO.getStudentRollNo());
                student.setStudentName(registerDTO.getStudentName());
                student.setStudentStd(Conversion.conversionOfNum(registerDTO.getStudentStd()));
                student.setMobileNo(registerDTO.getMobileNo());
                student.setStudentsMarks(studentsMarks);
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
    public ResponseEntity<Student> updateList(Long studentRollNo, UpdateDTO updateDTO) {


        Student upstudent = studentRepo.getStudentRollNo(studentRollNo)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "));

        upstudent.setStudentName(updateDTO.getStudentName());
        upstudent.setStudentStd(Conversion.conversionOfNum(updateDTO.getStudentStd()));
        upstudent.setMobileNo(updateDTO.getMobileNo());
        studentRepo.save(upstudent);

        return ResponseEntity.ok(upstudent);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteStudent(Long studentRollNo) {

        Student student= studentRepo.getStudentRollNo(studentRollNo)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + studentRollNo));
        studentRepo.delete(student);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @Override
    public ResponseEntity<Student> get(Long studentRollNo){
        Student student =studentRepo.getStudentRollNo(studentRollNo)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + studentRollNo));;
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