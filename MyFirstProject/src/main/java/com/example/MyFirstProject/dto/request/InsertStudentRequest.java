package com.example.MyFirstProject.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InsertStudentRequest {

  @NotNull(message = "id cannot be null")
  private Long id;

  @NotNull(message = "name cannot be null")
  private String name;

  @NotNull(message = "stream cannot be null")
  private String stream;

  @NotNull(message = "address cannot be null")
  private String address;

  @NotNull(message = "contact cannot be null")
  private String contact;

}
