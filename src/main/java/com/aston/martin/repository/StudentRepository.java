package com.aston.martin.repository;

import com.aston.martin.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepository {
    private final SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select s from Student s", Student.class)
                .getResultList();
    }

    @Transactional
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Student.class, id));
    }

    @Transactional
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }
}
