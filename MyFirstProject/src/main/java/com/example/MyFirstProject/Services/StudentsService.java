package com.example.MyFirstProject.Services;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Repositories.StudentsRepository;
import com.example.MyFirstProject.Utils.Constants;
import com.example.MyFirstProject.dto.request.InsertStudentRequest;
import com.example.MyFirstProject.dto.response.InsertStudentResponse;
import com.example.MyFirstProject.exception.StudentBadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.MyFirstProject.exception.ErrorMessage.ID_AND_NAME_ALREADY_EXIST;
import static com.example.MyFirstProject.exception.ErrorMessage.ID_DOES_NOT_EXIST;

@Slf4j
@Service
@Transactional
public class StudentsService {
  private static final Logger logger = LoggerFactory.getLogger(StudentsService.class);

  @Autowired
  private StudentsRepository studentsRepository;

  public List<Students> getAllActiveStudents()
  {
    List<Students> student = new ArrayList<>(studentsRepository.findAllByIsRevokedFalse());
    logger.info(Constants.SUCCESS);
    return student;
  }

  public List<Students> getAllInactiveStudents()
  {
    List<Students> student = new ArrayList<>(studentsRepository.findAllByIsRevokedTrue());
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

  public Long countActiveStudent()
  {
    logger.info(Constants.SUCCESS);
    return studentsRepository.countByIsRevokedFalse();
  }

  public Long countRevokedStudent()
  {
    logger.info(Constants.SUCCESS);
    return studentsRepository.countByIsRevokedTrue();
  }


  public InsertStudentResponse insertStudent(final InsertStudentRequest request) {

    this.validateRequest(request);

    final Students student = Students.builder()
      .id(request.getId())
      .name(request.getName())
      .stream(request.getStream())
      .address(request.getAddress())
      .contact(request.getContact())
      .build();

    final Students savedStudent = studentsRepository.save(student);
    logger.info(Constants.SUCCESS);

    return InsertStudentResponse.builder()
      .id(savedStudent.getId())
      .name(savedStudent.getName())
      .stream(savedStudent.getStream())
      .address(savedStudent.getAddress())
      .contact(savedStudent.getContact())
      .build();
  }


  public InsertStudentResponse updateStudent(final InsertStudentRequest request, Long id) {

      Students student = studentsRepository.findById(id).orElse(null);
      if(Objects.isNull(student))
      {
        log.error("Id does not exist to update {}", id);
        throw new StudentBadRequestException(ID_DOES_NOT_EXIST);
      }

      student.setId(request.getId());
      student.setName(request.getName());
      student.setStream(request.getStream());
      student.setAddress(request.getAddress());
      student.setContact(request.getContact());

      final Students savedStudent = studentsRepository.save(student);
      logger.info(Constants.SUCCESS);

      return InsertStudentResponse.builder()
        .id(savedStudent.getId())
        .name(savedStudent.getName())
        .stream(savedStudent.getStream())
        .address(savedStudent.getAddress())
        .contact(savedStudent.getContact())
        .build();

  }


  private void validateRequest(final InsertStudentRequest request) {

    final Optional<Students> studentOptional = studentsRepository.
      findByIdAndName(request.getId(), request.getName());

    if (studentOptional.isPresent()) {
      log.error("Id: {} & name: {} combination already exist",
        request.getId(), request.getName());
      throw new StudentBadRequestException(ID_AND_NAME_ALREADY_EXIST);
    }
  }


  public Students deleteStudentById(Long id)
  {
      Optional<Students> student = studentsRepository.findByIdAndIsRevokedFalse(id);
      if(student.isPresent())
      {
      Students revokedStudent = student.get();
      revokedStudent.setRevoked(true);
      studentsRepository.save(revokedStudent);
      logger.info(Constants.SUCCESS);
     }
     else
    {
      logger.warn(Constants.FAILURE);
    }
    return null;
  }

}
