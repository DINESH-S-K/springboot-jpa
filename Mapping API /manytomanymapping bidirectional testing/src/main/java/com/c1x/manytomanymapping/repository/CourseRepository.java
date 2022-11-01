package com.c1x.manytomanymapping.repository;

import com.c1x.manytomanymapping.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
