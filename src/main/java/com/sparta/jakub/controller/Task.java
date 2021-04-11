package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable {
    private final ArrayList<EmployeeDTO> employeesAfterChecker;
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Divider divider = new Divider();
    private int whichThread;
    private int numberOfThreads;


    Task(List<EmployeeDTO> employeesAfterChecker, int whichThread, int numberOfThreads) {
        this.employeesAfterChecker = (ArrayList<EmployeeDTO>) employeesAfterChecker;
        this.whichThread = whichThread;
        this.numberOfThreads = numberOfThreads;
    }


    @Override
    public void run() {
        try {
            employeeDAO.addEmployees(divider.arrayDivider(employeesAfterChecker, whichThread, numberOfThreads));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



