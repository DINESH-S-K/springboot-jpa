package com.c1x.manytomany.controller;

import com.c1x.manytomany.entity.Course;
import com.c1x.manytomany.entity.Student;
import com.c1x.manytomany.repository.CourseRepository;
import com.c1x.manytomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1/manytomany")
public class ManyToManyApplicationController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("addCourse")
    public Course addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return course;
    }

    @PostMapping("addStudents")
    public Student addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @PostMapping("addStudent/student/{id}")
    public Course addStudentsInCourse(@PathVariable long id, @RequestBody Set<Student> studentsSet) {
        Course getCourse = courseRepository.findById(id).orElseThrow(null);
        Set<Student> addStudents = new HashSet<>();
        for (Student student :
                studentsSet) {
            Student getStudent = studentRepository.findById(student.getId()).orElseThrow(null);
            addStudents.add(getStudent);
        }
        getCourse.setStudents(addStudents);
        courseRepository.save(getCourse);
        return getCourse;

    }


    @GetMapping("getCourse/{id}")
    public Course getCourse(@PathVariable long id) {
        Course getCourse = courseRepository.findById(id).orElseThrow(null);
        return getCourse;
    }

    @GetMapping("getStudents/{id}")
    public Student getStudents(@PathVariable long id) {
        Student getStudent = studentRepository.findById(id).orElseThrow(null);
        return getStudent;
    }

//    @PutMapping("update/course/{id}")
//    public Course updateCourseById(@PathVariable long id, @RequestBody Course course) {
//        Course getCourse = courseRepository.findById(id).orElseThrow(null);
//        Set<Student> getStudentSet = getCourse.getStudents();
//
//        Set<Student> studentSet = course.getStudents();
//
//        Iterator iterator = studentSet.iterator();
//        if(iterator.hasNext()){
//          Student student   = (Student) iterator.next();
//          student.setName(get);
//        }
//        getCourse.setName(course.getName());
//        getCourse.getStudents().addAll(course.getStudents());
//        getCourse.setStudents(getCourse.getStudents());

//        courseRepository.save(getCourse);
//        return getCourse;
//
//    }

    @PutMapping("update/addcourse/{id}")
    public Course updateAddCourseById(@PathVariable long id, @RequestBody Course course) {
        Course getCourse = courseRepository.findById(id).orElseThrow(null);
        getCourse.setName(course.getName());
        getCourse.getStudents().addAll(course.getStudents());
        getCourse.setStudents(getCourse.getStudents());

        courseRepository.save(getCourse);
        return getCourse;

    }

    @PutMapping("update/student/{id}")
    public Student updateStudnetById(@PathVariable long id, @RequestBody Student student) {
        Student getStudent = studentRepository.findById(id).orElseThrow(null);
        getStudent.setName(student.getName());

        studentRepository.save(getStudent);
        return getStudent;

    }

    @DeleteMapping("delete/course/{id}")
    public Course deleteCourseById(@PathVariable long id) {
        Course course = courseRepository.findById(id).orElseThrow(null);
        course.setStudents(null);
        courseRepository.deleteById(id);
        return course;
    }

    @DeleteMapping("delete/student/{id}")
    public Student deleteStudentById(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow(null);
        studentRepository.deleteById(id);
        return student;
    }
}
