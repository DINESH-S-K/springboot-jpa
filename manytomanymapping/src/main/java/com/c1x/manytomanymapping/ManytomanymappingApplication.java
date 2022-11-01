package com.c1x.manytomanymapping;

import com.c1x.manytomanymapping.entity.Courses;
import com.c1x.manytomanymapping.entity.Students;
import com.c1x.manytomanymapping.repository.CourseRepository;
import com.c1x.manytomanymapping.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManytomanymappingApplication implements CommandLineRunner {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManytomanymappingApplication.class, args);
    }

    //unidirectional
//	@Override
//	public void run(String... args) throws Exception {
//		Students student = new Students();
//		student.setName("dinesh");
//
//		Courses course = new Courses();
//		course.setC_name("data_structures");
//
//		Courses course1 = new Courses();
//		course1.setC_name("SEM");
//
//		Courses course2 = new Courses();
//		course2.setC_name("C");
//
//		student.setCoursesList(Arrays.asList(course,course1,course2));
//
//		studentsRepository.save(student);
//	}

    //unidirectional
    @Override
    public void run(String... args) throws Exception {
        Students dinesh = new Students();
        dinesh.setName("Dinesh");
        Students gokul = new Students();
        gokul.setName("Gokul");
//        Students thiru = new Students();
//        thiru.setName("Thiru");

        Courses C = new Courses();
        C.setCourse_name("c");
        Courses java = new Courses();
        java.setCourse_name("java");
        Courses python = new Courses();
        python.setCourse_name("python");



        dinesh.getCourses().add(C);
        dinesh.getCourses().add(python);
        dinesh.getCourses().add(java);

        gokul.getCourses().add(python);
        gokul.getCourses().add(C);
        gokul.getCourses().add(java);

//        thiru.getCourses().add(java);


        C.getStudents().add(dinesh);
        python.getStudents().add(dinesh);
        java.getStudents().add(dinesh);

        python.getStudents().add(gokul);
        C.getStudents().add(gokul);
        java.getStudents().add(gokul);


//       java.getStudents().add(thiru);


        studentsRepository.save(dinesh);
        studentsRepository.save(gokul);
//        studentsRepository.save(thiru);

    }

}
