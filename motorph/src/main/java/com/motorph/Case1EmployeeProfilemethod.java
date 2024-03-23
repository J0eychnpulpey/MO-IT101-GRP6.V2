package com.motorph;

import java.util.List;
import java.util.Scanner;

// This class is responsible for displaying the employee profile.
// The core responsibility of this method is to fetch, search for, and display the details of an employee, given their employee number.
// The method reads the employee data from a CSV file, searches for the employee with the given employee number, and displays their details.
// The method also handles cases where the employee is not found or the employee number is invalid.

public class Case1EmployeeProfilemethod {
   public static void showEmployeeProfile() {
        Scanner input = new Scanner(System.in);   // Creates a Scanner to read user input.
        System.out.print("Enter employee number: ");
        String empNo = input.nextLine(); // Stores the entered employee number.


            EmployeeFileReader reader = new EmployeeFileReader(); // Creates an instance of EmployeeFileReader which presumably handles reading the CSV file.
// Calls the readEmployeesFromFile method of EmployeeFileReader to read employee data from the CSV and store it in a list of Employee objects.
            List<Employee> employees = reader.readEmployeesFromFile("/home/johnpaul/Documents/motorph/src/main/resources/MotorPH Employee Data - Employee Details.csv");  

            Employee foundEmployee = employees.stream()
                                              .filter(employee -> employee.getEmpNo().equals(empNo))
                                              .findFirst()
                                              .orElse(null);
// Searches for the employee with the given employee number in the list of employees.
            if (foundEmployee != null) {
                System.out.println("************************************************");
                System.out.println("Employee Number: " + foundEmployee.getEmpNo());
                System.out.println("Name: " + foundEmployee.getFirstName());
                System.out.println("Last Name: " + foundEmployee.getLastName());
                System.out.println("Birthday: " + foundEmployee.getBirthday());
                System.out.println("Address: " + foundEmployee.getAddress());
                System.out.println("Phone Number: " + foundEmployee.getPhoneNo());
                System.out.println("SSS Number: " + foundEmployee.getSssNo());
                System.out.println("TIN Number: " + foundEmployee.getTinNo());
                System.out.println("PhilHealth Number: " + foundEmployee.getPhilHealthNo());
                System.out.println("Status: " + foundEmployee.getStatus());
                System.out.println("Position: " + foundEmployee.getPosition());
                System.out.println("Supervisor: " + foundEmployee.getSupervisor());

                System.out.println("Basic Salary: " + foundEmployee.getBasicSalary());
                System.out.println("Rice Subsidy: " + foundEmployee.getRiceSubsidy());
                System.out.println("Phone Allowance " + foundEmployee.getPhoneAllowance());
                System.out.println("Clothing Allowance: " + foundEmployee.getClothingAllowance());
                System.out.println("Semi Month Salary: " + foundEmployee.getSemiMonthlyRate());
                System.out.println("Hourly Rate: " + foundEmployee.getHourlyRate());

// Displays the details of the found employee if the employee is found.
            } else {
                System.out.println("Employee not found. Only employee # 1 - 6 are available.");  
        } 
        input.close();
    }

}

