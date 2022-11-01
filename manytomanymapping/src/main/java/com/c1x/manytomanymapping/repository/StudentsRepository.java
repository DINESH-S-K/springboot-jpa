package com.c1x.manytomanymapping.repository;

import com.c1x.manytomanymapping.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Long> {
}
