package com.sparta.jakub.controller;

import com.sparta.jakub.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class Divider {

    public List<EmployeeDTO> arrayDivider(List<EmployeeDTO> list, int whichThread, int numberOfThreads) {
        List<EmployeeDTO> threadList = new ArrayList<>();
        if (list.size() % numberOfThreads == 0) {
            int threadSize = list.size() / numberOfThreads;
            int n = (whichThread - 1) * threadSize;
            for (int i = n; i < threadSize * whichThread; i++) {
                threadList.add(list.get(n));
            }
        } else {
            int reminder = list.size() % numberOfThreads;
            int threadSize = (list.size() - reminder) / (numberOfThreads - 1);
            int n = (whichThread - 1) * threadSize;
            if (whichThread < numberOfThreads) {
                for (int i = n; i < threadSize * whichThread; i++) {
                    threadList.add(list.get(n));
                }
            } else {
                for (int i = n; i < list.size(); i++) {
                    threadList.add(list.get(n));
                }
            }
        }
        return threadList;
    }


}
