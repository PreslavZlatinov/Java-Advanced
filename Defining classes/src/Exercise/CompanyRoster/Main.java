package Exercise.CompanyRoster;

import Exercise.CompanyRoster.Department;
import Exercise.CompanyRoster.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departmentList = new ArrayList<>();
        while (n-- > 0) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");

            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            switch (employeeInfo.length){
                case 4:
                    employee = new Employee(name,salary,position,department);
                    break;
                case 5:
                    if(employeeInfo[4].matches("\\d+")){
                        int years = Integer.parseInt(employeeInfo[4]);
                        employee = new Employee(name,salary,position,department,years);
                    } else{
                        String email = employeeInfo[4];
                        employee = new Employee(name,salary,position,department,email);
                    }
                    break;
                case 6:
                    String email = employeeInfo[4];
                    int age = Integer.parseInt(employeeInfo[5]);

                    employee = new Employee(name,salary,position,department,email,age);
                    break;
            }

            boolean departmentExists = departmentList.stream().filter(dep -> dep.getName().equals(department)).count() >= 1;

            if(!departmentExists){
                departmentList.add(new Department(department));
            }

            Department currentDepartment = departmentList.stream()
                    .filter(dep -> dep.getName().equals(department)).findFirst().get();

            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departmentList.stream()
                .max(Comparator.comparingDouble(dep-> dep.calculateAverageSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(System.out::println);
    }
}
