package com.c1x.manytomanymapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.c1x.manytomanymapping.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {
}
