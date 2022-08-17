package com.ty.persondao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;
import com.ty.persondto.PersonDto;

public class PersonDao {

	public PersonDto savePerson(PersonDto dto) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String url = "jdbc:mysql://localhost:3306";
			Connection connection = DriverManager.getConnection(url, properties);
			String query = "INSERT INTO jdbc.person VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, dto.id);
			statement.setString(2, dto.name);
			statement.setLong(3, dto.phone);
			statement.setString(4, dto.email);
			statement.setString(5, dto.password);
			statement.setInt(6, dto.age);
			statement.execute();
			System.out.println("User Saved");
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public PersonDto findUserById(int id) {
		PersonDto dto = new PersonDto();
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String url = "jdbc:mysql://localhost:3306";
			Connection connection = DriverManager.getConnection(url, properties);
			String query = "SELECT * FROM jdbc.person WHERE id = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, id);
			ResultSet set = prepareStatement.executeQuery();
			set.next();
			dto.id = set.getInt(1);
			dto.name = set.getString(2);
			dto.phone = set.getLong(3);
			dto.email = set.getString(4);
			dto.password = set.getString(5);
			dto.age = set.getInt(6);
			connection.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;

	}

	public void deletePerson(int id) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String url = "jdbc:mysql://localhost:3306";
			Connection connection = DriverManager.getConnection(url, properties);
			String query = "DELETE FROM jdbc.person WHERE id = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			System.out.println("Person deleted");
			connection.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<PersonDto> getAllPersons() {
		List<PersonDto> persons = new ArrayList<>();
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String url = "jdbc:mysql://localhost:3306";
			Connection connection = DriverManager.getConnection(url, properties);
			String query = "SELECT * FROM jdbc.person";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				PersonDto dto = new PersonDto();
				dto.id = set.getInt(1);
				dto.name = set.getString(2);
				dto.phone = set.getLong(3);
				dto.email = set.getString(4);
				dto.password = set.getString(5);
				dto.age = set.getInt(6);
				persons.add(dto);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return persons;
	}
	
	public PersonDto validatePerson1(String email , String password) {
		PersonDto dto = new PersonDto();
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				FileInputStream fileInputStream = new FileInputStream("config.properties");
				Properties properties = new Properties();
				properties.load(fileInputStream);
				String url = "jdbc:mysql://localhost:3306";
				Connection connection = DriverManager.getConnection(url, properties);
				String query = "SELECT * FROM jdbc.person WHERE email = ? and binary password = ?";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, email);
				statement.setString(2, password);
				ResultSet set = statement.executeQuery(query);
				if (set.next()) 
				{
					dto.id  = set.getInt(1);
					dto.name = set.getString(2);
					dto.phone = set.getLong(3);
					dto.email = set.getString(4);
					dto.password = set.getString(5);
					dto.age = set.getInt(6);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return dto;
	}

}
