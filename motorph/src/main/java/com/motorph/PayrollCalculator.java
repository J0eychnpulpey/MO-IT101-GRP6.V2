package com.motorph;

import java.time.Month;
import java.util.List;


// This class is responsible for Salary deductions and Net Salary calculation and Gross Pay
/*
 * - Fetch Attendance Data = uses EmployeeAttendanceFileReader to read the attendance data of an employee for a given month and year.
 * - Fetch Hourly Rate = uses EmployeeFileReader to get the hourly rate of an employee.
 * - Calculate Total Hours Worked = calculates the total hours worked by an employee in a month.
 * - Calculate Gross Pay = calculates the gross pay of an employee based on the total hours worked and hourly rate.
 * - Calculate Deductions = calculates the SSS, PhilHealth, Withholding Tax, and Pag-IBIG deductions.
 * - Calculate Net Salary = calculates the net salary of an employee after deducting the SSS, PhilHealth, Withholding Tax, and Pag-IBIG contributions.
 * - Display Results = displays the results of the gross pay, deductions, and net salary.
 * 
 */
public class PayrollCalculator {

    // For Gross Pay Calculation

    public double calculateEmployeeTotalHoursWorked(String empId, int month, int year, double grossPay) {
        // 1. Get attendance Data
        EmployeeAttendanceFileReader attendanceFileReader = new EmployeeAttendanceFileReader();
        List<AttendanceRecord> attendanceData = attendanceFileReader.readEmployeeAttendanceFile(empId, "/home/johnpaul/Documents/motorph/src/main/resources/AttendancerecordmotorPhversion2.2.txt", month, year);

        // 2. Get Hourly Rate from Employee
        EmployeeFileReader employeeFileReader = new EmployeeFileReader();
        Employee employee = employeeFileReader.findEmployeeById(empId, "/home/johnpaul/Documents/motorph/src/main/resources/MotorPH Employee Data - Employee Details.csv");
        double hourlyRate = employee.getHourlyRate();


        // 3. Calculate Total Hours
        double totalMinutesWorked = 0.0;
        // reset totalMinutesWorked to 0 to avoid adding up minutes from previous calculations of months 
        for (AttendanceRecord record : attendanceData) {
            totalMinutesWorked += record.minutesWorked;
        }
        // 4. Convert total minutes to hours
        double TotalHoursWorked = totalMinutesWorked / 60;

        // 5. Calculate gross pay based on total hours worked
        grossPay = TotalHoursWorked * hourlyRate;


        // 6. Display Results
        System.out.println("************************************************");
        System.out.println("Employee #" + empId); 
        System.out.println("Employee Hourly Rate: " + hourlyRate);
        System.out.println("Month and Year: " + Month.of(month).name() + " " + year);
        System.out.println("Total Minutes Worked in a month: " + totalMinutesWorked);
        System.out.println("Total Hours Worked in a month: " + TotalHoursWorked);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("************************************************");



        return grossPay;
}


    // For Net Pay Calculation
    public void calculateNetSalary(String empId, int month, int year, double grossPay) {
          // ... (Existing code for getting attendance data and hourly rate)



        // Calculate Deductions
        double sssDeduction = new SSS().getSSSdeduction(grossPay);
        double philHealthDeduction = new PhilHealth().getPhilHealthDeduction(grossPay);
        double withHoldingTaxDeduction = new WithHoldingTax().getWithholdingTax(grossPay);
        double pagIbigDeduction = new PagIbig().getPagibigDeduction(grossPay);

        // Calculate Net Salary 
        double totalDeductions = sssDeduction + philHealthDeduction + withHoldingTaxDeduction + pagIbigDeduction;
        double netSalary = grossPay - totalDeductions;

        // Display Results
        System.out.println("************************************************");
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("SSS Deduction: " + sssDeduction);
        System.out.println("PhilHealth Deduction: " + philHealthDeduction);
        System.out.println("Withholding Tax Deduction: " + withHoldingTaxDeduction);
        System.out.println("Pag-IBIG Deduction: " + pagIbigDeduction);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("************************************************");


    }

}

