/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentsDao;
import java.util.List;
import javax.transaction.Transactional;
import model.Students;
import org.springframework.stereotype.Service;

/**
 *
 * @author aydar
 */
@Service
public class StudentsServiceImpl implements StudentsService{

    private StudentsDao studentsDao;

    public void setStudentsDao(StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    
    @Override
    @Transactional
    public void addStudent(Students student) {
        this.studentsDao.addStudent(student);
        
    }

    @Override
    @Transactional
    public void updateStudent(Students student) {
        this.studentsDao.updateStudent(student);
    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        this.studentsDao.removeStudent(id);
    }

    @Override
    @Transactional
    public Students getStudentById(int id) {
        return this.studentsDao.getStudentById(id);
    }

    @Override
    @Transactional
    public List<Students> listStudents() {
        return this.studentsDao.listStudents();
    }
    
}
