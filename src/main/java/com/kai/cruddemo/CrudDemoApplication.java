package com.kai.cruddemo;

import com.kai.cruddemo.dao.StudentDAO;
import com.kai.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student");
        Student newStudent = new Student("Dat", "Nguyen", "dat@gmail.com");

        System.out.println("Saving the student");
        studentDAO.save(newStudent);

        System.out.println("Student id: " + newStudent.getId());

    }
}
