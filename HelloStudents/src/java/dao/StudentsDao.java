/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Students;

/**
 *
 * @author aydar
 */
public interface StudentsDao {
    public void addStudent(Students student);
    public void updateStudent(Students student);
    public void removeStudent(int id);
    public Students getStudentById(int id);
    public List<Students> listStudents();
}
