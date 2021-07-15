package com.example.MyFirstProject.dto.common;

import com.example.MyFirstProject.Entity.Students;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
  private String message;
  private String code;
  private T response;

  public BaseResponse(T response) {
    this.response = response;
  }
  public BaseResponse(String message, String code) {
    this.message = message;
    this.code = code;
  }

}
