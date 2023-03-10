package net.java.registration.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.java.registration.model.*;

public class EmployeeDao {

	
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
		 String INSERT_USERS_SQL = "INSERT INTO employee "
				 + "(first_name, last_name, username, password, address, contact) values "
				 + "(?, ?, ?, ?, ?, ?);";

				 int result = 0;

				 Class.forName("com.mysql.jdbc.Driver");

				 try(
						 Connection connection = DriverManager.
						 getConnection("jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false", "james", "Ja96Ja96@");

						 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
						 )
						 {
						 preparedStatement.setString(1, employee.getFirstName());
						 preparedStatement.setString(2, employee.getLastName());
						 preparedStatement.setString(3, employee.getUsername());
						 preparedStatement.setString(4, employee.getPassword());
						 preparedStatement.setString(5, employee.getAddress());
						 preparedStatement.setString(6, employee.getContact());

						 System.out.println(preparedStatement);

						 result = preparedStatement.executeUpdate();

						 }
						 catch(SQLException e)
						 {
						 e.printStackTrace();
						 }
						 return result;
						 }
						 }
