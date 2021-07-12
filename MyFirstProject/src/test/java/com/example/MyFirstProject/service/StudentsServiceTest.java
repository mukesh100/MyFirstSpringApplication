package com.example.MyFirstProject.service;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Repositories.StudentsRepository;
import com.example.MyFirstProject.Services.StudentsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class StudentsServiceTest {

  @Autowired
  private StudentsService studentsService;

  @MockBean
  private StudentsRepository studentsRepository;

/*
  @Test
  void  getAllStudentsTest()
  {
    Students student1=new Students(1L,"Richard","Poet","USA","123456293", true ,LocalDateTime.now(),LocalDateTime.now());
    Students student2=new Students(2L,"Chris","Min","Mumbai","123456789", true ,LocalDateTime.now(),LocalDateTime.now());
    List<Students> studentList=new ArrayList<>();
    studentList.add(student1);
    studentList.add(student2);
    Mockito.when(studentsRepository.findAll()).thenReturn(studentList);
    assertEquals(studentsService.getAllActiveStudents().size(),2);
    assertEquals(studentsService.getAllActiveStudents(),studentList);
  }

  @Test
  void getStudentByNameTest()
  {
    Students actualStudent=new Students(1L,"Richard","Poet","USA","123456293", true ,LocalDateTime.now(),LocalDateTime.now());
    Mockito.when(studentsRepository.findByName("Richard")).thenReturn(Optional.of(actualStudent));
    Students new_student=studentsService.getStudentByName("Richard");
    assertEquals(new_student,actualStudent);
  }

  @Test
  void countStudent()
  {
    Students student1=new Students(1L,"Richard","Poet","USA","123456293", true ,LocalDateTime.now(),LocalDateTime.now());
    Students student2=new Students(2L,"Chris","Min","Mumbai","123456789", true ,LocalDateTime.now(),LocalDateTime.now());
    List<Students> studentList=new ArrayList<>();
    studentList.add(student1);
    studentList.add(student2);
    Mockito.when(studentsRepository.count()).thenReturn(2L);
    assertEquals(studentsService.countActiveStudent(),2);
  }
/*
  @Test
  void insertStudentTest()
  {
    Students actualStudent=new Students(15L,"Rohit","CSE","MP","12345678", false ,LocalDateTime.now(),LocalDateTime.now());
    Mockito.when(studentsRepository.saveAndFlush(actualStudent)).thenReturn(actualStudent);
    assertEquals(studentsService.insertStudent(actualStudent),actualStudent);
  }

 */

  /*
  @Test
  void updateStudentTest()
  {
    Students student=new Students(15L,"Rohit","CSE","MP","12345678", false ,LocalDateTime.now(),LocalDateTime.now());
    Mockito.when(studentsRepository.existsById(15L)).thenReturn(true);
    Mockito.when(studentsRepository.getOne(15L)).thenReturn(student);
    Students updatedStudent=new Students(15L,"Rohit","CSE","MP","12345678", false ,LocalDateTime.now(),LocalDateTime.now());
    BeanUtils.copyProperties(updatedStudent,student,"id");
    Mockito.when(studentsRepository.saveAndFlush(student)).thenReturn(student);
    assertEquals(studentsService.updateStudent(15L,updatedStudent),student);
  }



  @Test
  void DeleteStudentByIdTest()
  {
    Students student=new Students(15L,"Rohit","CSE","MP","12345678", false ,LocalDateTime.now(),LocalDateTime.now());
    Mockito.when(studentsRepository.existsById(15L)).thenReturn(true);
    Mockito.doNothing().when(studentsRepository).deleteById(15L);
    assertNull(studentsService.deleteStudentById(15L));
  }

   */

}
