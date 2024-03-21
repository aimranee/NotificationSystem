//package com.adria.notificationsystem.exception;
//
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//
//@Getter
//public class GenericException extends RuntimeException {
//
//    protected final ErrorCode errorCode;
//
//    protected HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//
//    public GenericException(ErrorCode errorCode) {
//        super(errorCode.getEngMessage());
//        this.errorCode = errorCode;
//    }
//
//    public GenericException(ErrorCode errorCode, Throwable cause) {
//        super(errorCode.getEngMessage(), cause);
//        this.errorCode = errorCode;
//    }
//
//    public GenericException(ErrorCode errorCode, HttpStatus status) {
//        super(errorCode.getEngMessage());
//        this.errorCode = errorCode;
//        this.httpStatus = status;
//    }
//
//}