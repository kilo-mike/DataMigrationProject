package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;
import com.sparta.jakub.view.Printer;

import java.util.List;

public class Starter {

    public static void start() {
        CSVReader reader = new CSVReader();
        DuplicateChecker duplicateChecker = new DuplicateChecker();
        MultiThreading multiThreading = new MultiThreading();
        double start, stop;
        String filepath = "resources/employees.csv";

        List<EmployeeDTO> employees = reader.readEmployees(filepath);

        List<EmployeeDTO> employeesAfterChecker = duplicateChecker.checker(employees);

        Printer.print(employees.size());
        Printer.print(employeesAfterChecker.size());

        start = System.nanoTime();
        multiThreading.threadPopulating(employeesAfterChecker, 40);
        stop = System.nanoTime();
        Printer.print((stop - start) / 1000000000.0);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.truncateTable();

    }
}
