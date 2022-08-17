package myjdbcpractise;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCrud {
	static  String dname = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/jdbc";
	static String data = "com.mysql.cj.jdbc.Driver";
	public void saveStudent(int id, String name, int age) {
		try {
			Class.forName(data);
			Connection connection = DriverManager.getConnection(url,dname, password);
			Statement statement = connection.createStatement();
			String query="INSERT INTO student values("+id+",'"+name+"',"+age+")";
			statement.execute(query);
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id) {
		
		try {
			Class.forName(data);
			Connection connection = DriverManager.getConnection(url, dname, password);
			Statement statement = connection.createStatement();
			String query="DELETE FROM student WHERE id = "+id;
			statement.execute(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudent(int id, String name, int age) {
		try {
			Class.forName(data);
			Connection connection = DriverManager.getConnection(url, dname, password);
			Statement statement = connection.createStatement();
			String query = "UPDATE student set name ='"+name+"',age="+age+" where id="+id+"";
			statement.execute(query);
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
