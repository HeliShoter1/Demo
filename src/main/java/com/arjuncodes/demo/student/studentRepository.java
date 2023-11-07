package com.arjuncodes.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<student,Integer>{
    @Query("SELECT s FROM student as s WHERE s.email = ?1")
    Optional<student> findStudentByEmail(String Email);
}
