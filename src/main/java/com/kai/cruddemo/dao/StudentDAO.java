package com.kai.cruddemo.dao;

import com.kai.cruddemo.entity.Student;


public interface StudentDAO {
    void save(Student student);
    Student findByID(Integer id);
}
