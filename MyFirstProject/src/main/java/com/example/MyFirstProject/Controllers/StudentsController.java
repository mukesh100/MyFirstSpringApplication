package com.example.MyFirstProject.Controllers;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Services.StudentsService;
import com.example.MyFirstProject.dto.common.BaseResponse;
import com.example.MyFirstProject.dto.request.InsertStudentRequest;
import com.example.MyFirstProject.dto.response.InsertStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
  ResponseEntity<List<Students>> getAllActiveStudent() {
    return ResponseEntity.ok(studentsService.getAllActiveStudents());
  }

  @GetMapping("getAllInactiveStudents")
  ResponseEntity<List<Students>> getAllInactiveStudent() {
    return ResponseEntity.ok(studentsService.getAllInactiveStudents());
  }

  @GetMapping("/getByName/{name}")
  ResponseEntity<Students> getStudentByName(@PathVariable String name) {
    return ResponseEntity.ok(studentsService.getStudentByName(name));
  }

  @GetMapping("/countActiveStudent")
  ResponseEntity<Long> countActiveStudent()
  {
    return ResponseEntity.ok(studentsService.countActiveStudent());
  }

  @GetMapping("/countRevokedStudent")
  ResponseEntity<Long> countRevokedActiveStudent()
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
  public ResponseEntity<BaseResponse<InsertStudentResponse>> updateStudent(Long id,
    @RequestBody @Valid @NotNull InsertStudentRequest request) {

    return new ResponseEntity<>(new BaseResponse<>(
      studentsService.updateStudent(request, id)),
      HttpStatus.OK);
  }



/*
  @PutMapping("/updateStudent/{id}")
  ResponseEntity<Students> updateStudent(@PathVariable Long id, @RequestBody @Validated Students student) {
    return ResponseEntity.ok(studentsService.updateStudent(id, student));
  }

 */



  @DeleteMapping("/deleteStudentById/{id}")
  ResponseEntity<Students> deleteStudentById(@PathVariable Long id) {
    return ResponseEntity.ok(studentsService.deleteStudentById(id));
  }

}
