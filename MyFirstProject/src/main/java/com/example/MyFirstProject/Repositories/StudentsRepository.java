package com.example.MyFirstProject.Repositories;

import com.example.MyFirstProject.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
  Optional<Students> findByName(String name);

}
