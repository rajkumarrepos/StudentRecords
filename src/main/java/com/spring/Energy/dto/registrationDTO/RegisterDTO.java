package com.spring.Energy.dto.registrationDTO;

import com.spring.Energy.conversion.Conversion;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterDTO {
@Autowired
private Conversion conversion;
    private Long studentID;

    private String studentName;

    private Integer studentStd;
    private Long mobileNo;
    public RegisterDTO() {
    }

    public RegisterDTO(Long studentID, String studentName, Integer studentStd, Long mobileNo) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentStd = studentStd;
        this.mobileNo = mobileNo;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentStd(){return studentStd;}


    public void setStudentStd(Integer studentStd) {
        this.studentStd = studentStd;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

}
