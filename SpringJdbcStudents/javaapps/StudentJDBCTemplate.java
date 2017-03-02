package javaapps;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer s_id, String name, Integer start_year) {
        String SQL = "INSERT INTO students (s_id, name, start_year) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, s_id, name, start_year);
        System.out.println("Created Record s_id = " + s_id + "name = " + name + "start_year = " + start_year);
        return;
    }

    @Override
    public Student getStudent(Integer s_id) {
        String SQL = "SELECT * FROM students WHERE s_id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{s_id}, new StudentMapper());

        return student;
    }

    @Override
    public List<Student> listStudents() {
        String SQL = "SELECT * FROM students";
        List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());

        return students;
    }

    @Override
    public void delete(Integer s_id) {
        String SQL = "DELETE FROM students WHERE s_id = ?";
        jdbcTemplateObject.update(SQL, s_id);
        System.out.println("Deleted Record with s_id = " + s_id);
        return;
    }

    @Override
    public void update(Integer s_id, String name, Integer start_year) {
        String SQL = "UPDATE students SET name = ?, start_year = ? WHERE s_id = ?";
        jdbcTemplateObject.update(SQL, name, start_year, s_id);
        System.out.println("Updated Record with s_id = " + s_id);
        return;
    }
}
