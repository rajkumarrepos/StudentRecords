package com.spring.Energy.exceptionController;



public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String errCode;
    private String errMessage;



    public CustomException() {
    }

    public CustomException(String errCode, String errMessage) {
        super();
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }



}
