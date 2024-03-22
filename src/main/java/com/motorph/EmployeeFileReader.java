package com.motorph;

 // For Case 1 "Show Employee Profile"

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

// This class is responsible for reading the employee data file and extracting the employee records.
public class EmployeeFileReader {
    public List<Employee> readEmployeesFromFile(String filename) {
        List<Employee> employees = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filename))) { //: Uses the CSVReader class from the OpenCSV library to efficiently read CSV files.
            reader.readNext(); // Skip header row

            String[] data;
            while ((data = reader.readNext()) != null) {
                // Constructs an Employee object using the parsed data from each row.
                Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], Double.parseDouble(data[13]), Double.parseDouble(data[14]), Double.parseDouble(data[15]), Double.parseDouble(data[16]), Double.parseDouble(data[17]), Double.parseDouble(data[18]));
                employees.add(employee);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading employee data file: " + filename);
        }

        return employees;
    }

    // This method finds an employee by their ID in the employee data file.
    public Employee findEmployeeById(String empId, String filename) { //: This method takes an employee ID and the filename of the employee data file as parameters.
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            reader.readNext(); // Skip header row

            String[] data;
            while ((data = reader.readNext()) != null) {
                if (data[0].equals(empId)) { // Check Employee # (Column 0)
                     Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], Double.parseDouble(data[13]), Double.parseDouble(data[14]), Double.parseDouble(data[15]), Double.parseDouble(data[16]), Double.parseDouble(data[17]), Double.parseDouble(data[18]));
                    return employee;
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading employee data file: " + filename);
        }
        return null;
    }




}
