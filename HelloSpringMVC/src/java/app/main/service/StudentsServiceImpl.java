package app.main.service;

import app.main.dao.StudentsDao;
import app.main.model.Students;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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