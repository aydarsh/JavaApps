package javaapps;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javaapps.StudentJDBCTemplate;

public class SpringJdbcStudents {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

        System.out.println("-----Records Creation-----");
        studentJDBCTemplate.create(1216, "Тимур", 2016);
        studentJDBCTemplate.create(1210, "Керим", 2010);
        studentJDBCTemplate.create(1181, "Айдар", 1981);

        System.out.println("-----Listing Records-----");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("s_id: " + record.getS_id());
            System.out.print(", name: " + record.getName());
            System.out.println(", start_year: " + record.getStart_year());
        }

        System.out.println("-----Updating Record with s_id = 1216-----");
        studentJDBCTemplate.update(1216, "Рустем", 1988);
        System.out.println("-----Listing Record with s_id = 1216-----");
        Student student = studentJDBCTemplate.getStudent(1216);
        System.out.print("s_id: " + student.getS_id());
        System.out.print(", name: " + student.getName());
        System.out.println(", start_year: " + student.getStart_year());
    }
}
