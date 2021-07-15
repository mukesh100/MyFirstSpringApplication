package com.example.MyFirstProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorMessage {
  ID_AND_NAME_ALREADY_EXIST("Id & name combination already exist", "CDC_001",
    HttpStatus.BAD_REQUEST),

  ID_DOES_NOT_EXIST("Id does not exist in database", "CDC_002",
    HttpStatus.BAD_REQUEST)
  ;

  private final String message;
  private final String code;
  private final HttpStatus status;
}
