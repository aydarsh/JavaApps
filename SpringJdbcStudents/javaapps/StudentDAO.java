package javaapps;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer s_id, String name, Integer start_year);
    public Student getStudent(Integer s_id);
    public List<Student> listStudents();
    public void delete(Integer s_id);
    public void update(Integer s_id, String name, Integer start_year);
}
