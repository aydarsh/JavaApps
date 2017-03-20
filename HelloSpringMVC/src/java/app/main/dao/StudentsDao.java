package app.main.dao;

import app.main.model.Students;
import java.util.List;

public interface StudentsDao {
    public void addStudent(Students student);
    public void updateStudent(Students student);
    public void removeStudent(int id);
    public Students getStudentById(int id);
    public List<Students> listStudents();
}