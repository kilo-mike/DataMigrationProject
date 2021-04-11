package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVReader {

    public List<EmployeeDTO> readEmployees(String fileName) {
        List<EmployeeDTO> employees = new ArrayList<>();
        Path path = Paths.get(fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                EmployeeDTO employeeDTO = createEmployee(attributes);
                employees.add(employeeDTO);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private static EmployeeDTO createEmployee(String[] data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        int employee_id = Integer.parseInt(data[0]);
        String name_prefix = data[1];
        String first_name = data[2];
        String middle_initial = data[3];
        String last_name = data[4];
        String gender = data[5];
        String email = data[6];
        Date date_of_birth = null;
        Date date_of_join = null;
        try {
            date_of_birth = format.parse(data[7]);
            date_of_join = format.parse(data[8]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int salary = Integer.parseInt(data[9]);

        return new EmployeeDTO(employee_id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_join, salary);
    }
}
