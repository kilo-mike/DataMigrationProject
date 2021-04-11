package com.sparta.jakub;

import com.sparta.jakub.controller.CSVReader;
import com.sparta.jakub.controller.DuplicateChecker;
import com.sparta.jakub.controller.EmployeeDAO;
import com.sparta.jakub.controller.MultiThreading;
import com.sparta.jakub.model.EmployeeDTO;
import com.sparta.jakub.view.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PerformanceTest {

    CSVReader reader = new CSVReader();
    DuplicateChecker duplicateChecker = new DuplicateChecker();
    MultiThreading multiThreading = new MultiThreading();
    double start, stop;
    String filepath = "resources/employees.csv";
    List<EmployeeDTO> employees = reader.readEmployees(filepath);
    List<EmployeeDTO> employeesAfterChecker = duplicateChecker.checker(employees);

    @BeforeEach
    void setUp() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.truncateTable();
    }

    @Test
    void singleThread() {
        start = System.nanoTime();
        multiThreading.threadPopulating(employeesAfterChecker, 1);
        stop = System.nanoTime();
        Printer.print("Time of inserting 1 thread in sec");
        Printer.print((stop - start) / 1000000000.0);

    }

    @Test
    void fiveThreads() {
        start = System.nanoTime();
        multiThreading.threadPopulating(employeesAfterChecker, 5);
        stop = System.nanoTime();
        Printer.print("Time of inserting 5 threads in sec");
        Printer.print((stop - start) / 1000000000.0);

    }
    @Test
    void tenThreads() {
        start = System.nanoTime();
        multiThreading.threadPopulating(employeesAfterChecker, 10);
        stop = System.nanoTime();
        Printer.print("Time of inserting 10 threads in sec");
        Printer.print((stop - start) / 1000000000.0);

    }
    @Test
    void twentyThreads() {
        start = System.nanoTime();
        multiThreading.threadPopulating(employeesAfterChecker, 20);
        stop = System.nanoTime();
        Printer.print("Time of inserting 20 threads in sec");
        Printer.print((stop - start) / 1000000000.0);

    }

}
