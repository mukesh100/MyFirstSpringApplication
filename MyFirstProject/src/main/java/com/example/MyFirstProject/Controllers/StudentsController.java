package com.example.MyFirstProject.Controllers;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Services.StudentsService;
import com.example.MyFirstProject.dto.common.BaseResponse;
import com.example.MyFirstProject.dto.request.InsertStudentRequest;
import com.example.MyFirstProject.dto.response.InsertStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentsController {

  @Autowired
  private StudentsService studentsService;


  @GetMapping("getAllActiveStudents")
  public ResponseEntity<List<Students>> getAllActiveStudent() {
    return ResponseEntity.ok(studentsService.getAllActiveStudents());
  }


  @GetMapping("getAllInactiveStudents")
  public ResponseEntity<List<Students>>getAllInactiveStudent() {
    return ResponseEntity.ok(studentsService.getAllInactiveStudents());
  }

  @GetMapping("/getByName/{name}")
  public ResponseEntity<Students> getStudentByName(@PathVariable String name) {
    return ResponseEntity.ok(studentsService.getStudentByName(name));
  }

  @GetMapping("/countActiveStudent")
  public ResponseEntity<Long> countActiveStudent()
  {
    return ResponseEntity.ok(studentsService.countActiveStudent());
  }

  @GetMapping("/countRevokedStudent")
  public ResponseEntity<Long> countRevokedActiveStudent()
  {
    return ResponseEntity.ok(studentsService.countRevokedStudent());
  }


  @PostMapping("/insertStudent")
  public ResponseEntity<BaseResponse<InsertStudentResponse>> insertStudent(
    @RequestBody @Valid @NotNull InsertStudentRequest request) {

    return new ResponseEntity<>(new BaseResponse<>(
      studentsService.insertStudent(request)),
      HttpStatus.OK);
  }


  @PutMapping("/updateStudent/{id}")
  public ResponseEntity<BaseResponse<InsertStudentResponse>> updateStudent(
    @RequestBody @Valid @NotNull InsertStudentRequest request, @PathVariable  @NotNull(message = "Id is mandatory") Long id) {

    return new ResponseEntity<>(new BaseResponse<>(
      studentsService.updateStudent(request, id)),
      HttpStatus.OK);
  }


  @DeleteMapping("/deleteStudentById/{id}")
  public ResponseEntity<Students> deleteStudentById(@PathVariable Long id) {
    return ResponseEntity.ok(studentsService.deleteStudentById(id));
  }

}
