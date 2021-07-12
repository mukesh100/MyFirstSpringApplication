package com.example.MyFirstProject.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentDto {
  @NotNull
  private Long id;
  @NotNull
  private String name;
  @NotNull
  private String stream;
  @NotNull
  private String address;
  @NotNull
  private String contact;
}
