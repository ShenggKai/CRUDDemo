package com.kai.cruddemo;

import com.kai.cruddemo.dao.StudentDAO;
import com.kai.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            readStudent(1, studentDAO);
//            queryStudent(studentDAO);
            findStudentByLastName(studentDAO);
        };
    }

    private void findStudentByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Tran");

        if (students.isEmpty()) {
            System.out.println("Can't find any student");
        } else
            for (Student student : students) {
                System.out.println(student);
            }
    }

    private void queryStudent(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(int id, StudentDAO studentDAO) {
        System.out.println("Reading student: " + id);
        Student myStudent = studentDAO.findByID(id);

        System.out.println(myStudent);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student");
        Student newStudent = new Student("Dat", "Nguyen", "dat@gmail.com");

        System.out.println("Saving the student");
        studentDAO.save(newStudent);

        System.out.println("Student id: " + newStudent.getId());

    }
}
