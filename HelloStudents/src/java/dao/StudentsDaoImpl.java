/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.logging.Logger;
import model.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aydar
 */
@Repository
public class StudentsDaoImpl implements StudentsDao{

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StudentsDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public void addStudent(Students student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(student);
        logger.info("Student successfully saved. Student details: "+student);
    }

    @Override
    public void updateStudent(Students student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
        logger.info("Student successfully updated. Student details: "+student);
    }

    @Override
    public void removeStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Students student = (Students) session.load(Students.class, new Integer (id));
        
        if(student!=null){
            session.delete(student);
        }
        logger.info("Student successfully removed. Student details: "+student);
    }
    

    @Override
    public Students getStudentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Students student = (Students) session.load(Students.class, new Integer (id));
        logger.info("Student successfully loaded. Student details: "+student);
        
        return student;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Students> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Students> studentsList = session.createQuery("from Students").list();
        
        for(Students student: studentsList){
            logger.info("Students list: "+student);
        }
        
        return studentsList;
    }
    
}
