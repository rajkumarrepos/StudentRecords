package com.spring.Energy.dto.registrationDTO;

public class StudentsDTO {
    private Long studentID;

    private String studentName;

    private String studentStd;
    private Long mobileNo;
    public StudentsDTO(){
    }

    public StudentsDTO(Long studentID, String studentName, String studentStd, Long mobileNo) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentStd = studentStd;
        this.mobileNo = mobileNo;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentStd() {
        return studentStd;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

}


