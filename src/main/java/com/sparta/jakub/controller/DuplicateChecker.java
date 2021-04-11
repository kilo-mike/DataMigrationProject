package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateChecker {

   private Map<Integer, EmployeeDTO> duplicates = new HashMap<>();
   private Map<Integer,EmployeeDTO> duplicates2 = new HashMap<>();

    public List<EmployeeDTO> checker(List<EmployeeDTO> employees){
        List<EmployeeDTO> employeesWithoutDuplicate = new ArrayList<>();
        for (int i =0 ;i<employees.size(); i++ )
        if (duplicates.containsKey(employees.get(i).getEmployee_id())){
            duplicates2.put(employees.get(i).getEmployee_id(),employees.get(i));
        }else {
            duplicates.put(employees.get(i).getEmployee_id(),employees.get(i));
            employeesWithoutDuplicate.add(employees.get(i));
        }
        return employeesWithoutDuplicate;

    }
}
