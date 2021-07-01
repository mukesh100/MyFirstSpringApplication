package com.example.MyFirstProject.Controllers;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentsController {

  @Autowired
  private StudentsService studentsService;

  @GetMapping("getAll")
  public List<Students> MyList()
  {
    return studentsService.getAllStudents();
  }

  @GetMapping("/getByName/{name}")
  public Students getStudentByName(@PathVariable String name)
  {
    return studentsService.getStudentByName(name);
  }

  @GetMapping("/countStudent")
  public  Long countStudent()
  {
    return studentsService.countStudent();
  }
  @PostMapping("/insertStudent")
  public Students insertStudent(@RequestBody Students student)
  {
    return studentsService.insertStudent(student);
  }

  @PutMapping("/updateStudent/{id}")
  public Students UpdateStudent(@RequestBody Students student,@PathVariable Long id)
  {
    return studentsService.updateStudent(id,student);
  }

  @DeleteMapping("/deleteStudentById/{id}")
  public Students deleteTopicsById(@PathVariable Long id)
  {
    return studentsService.deleteStudentById(id);
  }

}
