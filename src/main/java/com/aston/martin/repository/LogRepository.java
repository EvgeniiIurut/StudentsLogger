package com.aston.martin.repository;

import com.aston.martin.domain.LogEntity;
import com.aston.martin.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class LogRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public LogRepository(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

//    @Transactional
//    public List<LogEntity> getLogsForStudent(int id) {
//
//        Session session = sessionFactory.getCurrentSession();
//        Student student = session.get(Student.class, id);
//        Hibernate.initialize(student.getLogs());
//        List<LogEntity> logs = student.getLogs();
//
//        return logs;
//    }

    @Transactional
    public void add(int id, String message) {

        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        LogEntity log = new LogEntity(student, message, new Date());
        session.save(log);
    }

    @Transactional
    public void update(int logId, String message) {
        Session session = sessionFactory.getCurrentSession();
        LogEntity log = session.get(LogEntity.class, logId);
        log.setMessage(message);
    }
}
