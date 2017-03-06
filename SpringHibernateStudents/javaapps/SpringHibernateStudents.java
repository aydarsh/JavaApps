package javaapps;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class SpringHibernateStudents {
    private static SessionFactory factory;
    public static void main(String[] args){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        SpringHibernateStudents springHibernateStudents = new SpringHibernateStudents();
//        Add students
        Integer st1 = springHibernateStudents.addStudent(6037, "Роберт", 2000);
        Integer st2 = springHibernateStudents.addStudent(5037, "Марат", 1999);
//        List students
        springHibernateStudents.listStudents();
//        Update student's start_year info
        springHibernateStudents.updateStudent(st1, 2001);
//        Delete a student
        springHibernateStudents.deleteStudent(st2);
//        List changed students list
        springHibernateStudents.listStudents();
    }

//  method to add a student to the database
    public Integer addStudent(Integer s_id, String name, Integer start_year){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer studentId = null;
        try {
            tx = session.beginTransaction();
            Student student = new Student(s_id, name, start_year);
            studentId = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return studentId;
    }

//    method to list all the students from the database
    public void listStudents(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List students = session.createQuery("From Student").list();
            for (Iterator iterator = students.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.print("s_id: " + student.getId());
                System.out.print(" name: " + student.getName());
                System.out.println(" start_year: " + student.getStart_year());
            }
            tx.commit();
        } catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    method to update start_year for a student
    public void updateStudent(Integer s_id, Integer start_year){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, s_id);
            student.setStart_year(start_year);
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    method to delete a student from the database
    public void deleteStudent(Integer s_id){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, s_id);
            session.delete(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
