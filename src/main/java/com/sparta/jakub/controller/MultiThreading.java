package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;

import java.util.List;

public class MultiThreading {

    public void threadPopulating(List<EmployeeDTO> list, int numberOfThread) {

        for (int i = numberOfThread ; i> 1 ;i --){
            Task task = new Task(list,i,numberOfThread);
            Thread thread = new Thread(task);
            thread.start();
        }
        Task task = new Task(list,1,numberOfThread);
        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
