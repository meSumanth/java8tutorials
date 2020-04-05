package com.java8tutorials.streams;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Uday"));
        employeeList.add(new Employee(1, "Sumanth"));
        employeeList.add(new Employee(2, "Ashok"));
        employeeList.add(new Employee(3, "Naidu"));

        //Approach 1
        Map<Integer, String> map = employeeList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName, (oldKey, newKey) ->oldKey));
        System.out.println("Converted map: "+ map);

        //Approach 2
        Map<Integer, String> map1 = employeeList.stream().collect(Collectors.toMap(emp -> emp.getId(), emp -> emp.getName(), (oldKey, newKey) -> oldKey));
        System.out.println("Converted Map: "+ map1);

        //Third argument is to handle duplicate key

        //Sorting by id
        Map<Integer, String> sortedMap = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getId))
                .collect(Collectors.toMap(Employee::getId, Employee::getName, (oldKey, newKey) -> oldKey));
        System.out.println("Sorted Map: "+ sortedMap);

        //Descending order
        Map<Integer, String> sortedDescOrderMap = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getId).reversed())
                .collect(Collectors.toMap(Employee::getId, Employee::getName, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("Sorted in Descending order: "+ sortedDescOrderMap);
    }

}
