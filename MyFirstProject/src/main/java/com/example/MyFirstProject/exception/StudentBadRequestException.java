package com.example.MyFirstProject.exception;


public class StudentBadRequestException extends RuntimeException{


  protected ErrorMessage errorMessage;
  protected String message;
  protected String code;
  protected Throwable cause;
  protected boolean logException;

  public StudentBadRequestException(
    final Throwable cause, final ErrorMessage errorMessage, final String message) {
    super();
    this.cause = cause;
    this.errorMessage = errorMessage;
    this.message = message;
  }

  public StudentBadRequestException(final String message) {
    super();
    this.message = message;
  }

  public StudentBadRequestException(final ErrorMessage errorMessage) {
    super();
    this.message = errorMessage.getMessage();
    this.code = errorMessage.getCode();
  }

  public StudentBadRequestException(final ErrorMessage errorMessage, final boolean logException) {
    super();
    this.message = errorMessage.getMessage();
    this.code = errorMessage.getCode();
    this.logException = logException;
  }
}
