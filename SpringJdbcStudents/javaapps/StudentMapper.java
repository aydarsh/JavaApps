package javaapps;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setS_id(rs.getInt("s_id"));
        student.setName(rs.getString("name"));
        student.setStart_year(rs.getInt("start_year"));

        return student;
    }
}
