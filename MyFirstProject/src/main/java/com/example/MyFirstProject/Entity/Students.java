package com.example.MyFirstProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "students")
public class Students {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", updatable = false, nullable = false)
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="stream")
  private String stream;

  @Column(name="address")
  private String address;

  @Column(name="contact")
  private String contact;
  
   private boolean is_revoked = Boolean.FALSE;

  @Column(name="is_Revoked")
  private boolean isRevoked = Boolean.FALSE;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
  @CreationTimestamp
  @Column(name="creation_timestamp",nullable = false,updatable = false)
  private LocalDateTime create_timestamp;

  @UpdateTimestamp
  @Column(name="updated_timestamp",nullable = false)
  private LocalDateTime update_timestamp;

}
