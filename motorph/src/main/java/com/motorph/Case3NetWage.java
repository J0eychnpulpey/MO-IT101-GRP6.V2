package com.motorph;

import java.util.Scanner;

// This class is designed to handle the calculation of the net wage of an employee.
public class Case3NetWage {
   public static void ShowNetWage() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter employee ID: (type 1 - 6 only for now, more employees will be added in the future.)");
            String empId = input.nextLine();

            System.out.print("Enter month (1-12): ");
            int month = input.nextInt();

            System.out.print("Enter year:  (type 2024)  ");
            int year = input.nextInt();

            PayrollCalculator calculator = new PayrollCalculator();
            double grossPay = 0.0;
            grossPay = calculator.calculateEmployeeTotalHoursWorked(empId, month, year, grossPay);
            calculator.calculateNetSalary(empId, month, year, grossPay);
        } finally {
            input.close();
        }
    }
}

