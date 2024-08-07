package com.kai.cruddemo.dao;

import com.kai.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "SELECT s from Student s ORDER BY firstName DESC", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String name) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "SELECT s from Student s WHERE s.lastName = :lastName", Student.class
        );

        theQuery.setParameter("lastName", name);

        return theQuery.getResultList();
    }
}
