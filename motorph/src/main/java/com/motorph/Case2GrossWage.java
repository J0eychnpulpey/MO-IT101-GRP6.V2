package com.motorph;

import java.util.Scanner;
// This class is designed to handle the calculation of the gross wage of an employee.
public class Case2GrossWage {
    public static void showGrossWage() {
    Scanner input = new Scanner(System.in);

    try { //The primary logic for calculation is enclosed in a try block to handle potential errors gracefully (such as invalid input or issues with finding attendance data).
        System.out.print("Enter employee ID: (type 1 -6 only for now, more employees will be added in the future)");
        String empId = input.nextLine();

        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter year (type 2024): ");
        int year = input.nextInt();


        // Proceed with calculation if attendance data exists
        PayrollCalculator calculator = new PayrollCalculator(); // object is created, which likely handles the detailed gross pay calculations.
        double grossPay = 0.0; // Initialize grossPay variable
        grossPay = calculator.calculateEmployeeTotalHoursWorked(empId, month, year, grossPay); // Add semicolon here

    } finally { //The finally block ensures that the Scanner is closed even if an exception occurs.
        input.close();
    }


    }
}

