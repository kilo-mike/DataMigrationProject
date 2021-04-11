package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {

    private final String URL = "jdbc:mysql://localhost:3306/Jakub";
    private Connection connection;
    private Properties properties = new Properties();

    private String truncateEmployees = "TRUNCATE employees";
    private String addEmployee = "insert into employees values (?,?,?,?,?,?,?,?,?,?);";

    private Connection connectToDatabase() {
        try {
            properties.load(new FileReader("resources/login.properties"));
            connection = DriverManager.getConnection(URL, properties.getProperty("username"), properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void addEmployee(EmployeeDTO employee) {
        try (PreparedStatement preparedStatement = connectToDatabase().prepareStatement(addEmployee)) {
            preparedStatement.setInt(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getName_prefix());
            preparedStatement.setString(3, employee.getFirst_name());
            preparedStatement.setString(4, employee.getMiddle_initial());
            preparedStatement.setString(5, employee.getLast_name());
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setDate(8, new java.sql.Date(employee.getDate_of_birth().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(employee.getDate_of_join().getTime()));
            preparedStatement.setInt(10, employee.getSalary());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployees(List<EmployeeDTO> listOfEmployees) throws SQLException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connectToDatabase().prepareStatement(addEmployee);
            for (EmployeeDTO employee : listOfEmployees) {
                addEmployee(employee);
            }
        } finally {
            connection.close();
        }
    }

    public void truncateTable() {
        try (PreparedStatement preparedStatement = connectToDatabase().prepareStatement(truncateEmployees)) {
            preparedStatement.executeUpdate();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connectToDatabase().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


