import java.sql.*;

public class JDBCstudents {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost/test";
	static final String USER = "postgres";
	static final String PASS = "postgres";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT students.name, avg(exams.score) AS mark FROM students JOIN exams ON students.s_id=exams.s_id GROUP BY students.name";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("name");
				String mark = rs.getString("mark");

				System.out.println("Name: " + name + "\tMark: " + mark);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if (stmt!=null) {
					stmt.close();
				}
			}catch (SQLException se2) {
				
			}
			try{
				if (conn!=null) {
					conn.close();
				}
			}catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}