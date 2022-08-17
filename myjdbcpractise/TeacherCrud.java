package myjdbcpractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherCrud {

	static String dname = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/jdbc";
	static String data = "com.mysql.cj.jdbc.Driver";

	public void addTeacher(int id, String name, String subject) {
		try {
			Class.forName(data);
			Connection connection = DriverManager.getConnection(url, dname, password);
			Statement statement = connection.createStatement();
			String query = "INSERT into teacher VALUES(" + id + ",'" + name + "','" + subject + "')";
			statement.execute(query);
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTeacher(int tid) {
		try {
			Class.forName(data);
			Connection connection = DriverManager.getConnection(url, dname, password);
			Statement statement = connection.createStatement();
			String query = "DELETE FROM teacher WHERE tid = "+ tid;
			statement.execute(query);
			System.out.println("Teaher data deleted successfully.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
