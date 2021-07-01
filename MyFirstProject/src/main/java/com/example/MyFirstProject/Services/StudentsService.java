package com.example.MyFirstProject.Services;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Repositories.StudentsRepository;
import com.example.MyFirstProject.Utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentsService {
  private static final Logger logger = LoggerFactory.getLogger(StudentsService.class);

  @Autowired
  private StudentsRepository studentsRepository;

  public List<Students> getAllStudents()
  {
    List<Students> student = new ArrayList<>(studentsRepository.findAllByActiveTrue());
    logger.info(Constants.SUCCESS);
    return student;
  }
  public Students getStudentByName(String name)
  {
    Optional<Students> student = studentsRepository.findByName(name);
    if(student.isPresent())
    {
      logger.info(Constants.SUCCESS);
      return student.get();
    }
    else
    {
      logger.warn(Constants.FAILURE);
      return null;
    }
  }

  public Long countStudent()
  {
    return studentsRepository.count();
  }

  public Students insertStudent(Students student)
  {
    Students savedStudent=studentsRepository.saveAndFlush(student);
    logger.info(Constants.SUCCESS);
    return savedStudent;
  }

  public Students updateStudent(Long id, Students student)
  {
    if(studentsRepository.existsById(id))
    {
      Students existingStudent=studentsRepository.getOne(id);
      BeanUtils.copyProperties(student,existingStudent,"id");
      student=studentsRepository.saveAndFlush(existingStudent);
      logger.info(Constants.SUCCESS);
    }
    else
    {
      logger.warn(Constants.FAILURE);
      student=null;
    }
    return student;
  }

  public Students deleteStudentById(Long id)
  {
    if (studentsRepository.existsById(id))
    {
      studentsRepository.deleteById(id);
      logger.info(Constants.SUCCESS);
    }
    else
    {
      logger.warn(Constants.FAILURE);
    }
    return null;
  }


}
