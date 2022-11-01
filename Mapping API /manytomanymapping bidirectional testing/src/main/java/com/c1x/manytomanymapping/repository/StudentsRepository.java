package com.c1x.manytomanymapping.repository;

import com.c1x.manytomanymapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,Long> {
}
