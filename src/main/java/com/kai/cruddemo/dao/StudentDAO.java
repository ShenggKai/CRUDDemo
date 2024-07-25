package com.kai.cruddemo.dao;

import com.kai.cruddemo.entity.Student;

import java.util.List;


public interface StudentDAO {
    void save(Student student);
    Student findByID(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String name);
}
