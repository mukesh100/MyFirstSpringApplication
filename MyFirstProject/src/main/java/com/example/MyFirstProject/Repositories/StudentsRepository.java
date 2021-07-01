package com.example.MyFirstProject.Repositories;

import com.example.MyFirstProject.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
  Optional<Students> findByName(String name);
  @Query("select s from Students s where s.is_revoked=false")
  List<Students> findAllByActiveTrue();

}
