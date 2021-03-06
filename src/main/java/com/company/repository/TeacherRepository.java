package com.company.repository;

import com.company.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Long> {
//    @Query("select c from Teacher c where c.authInfo.email = ?1")
//    Optional<Teacher> findByEmail(String email);
}
