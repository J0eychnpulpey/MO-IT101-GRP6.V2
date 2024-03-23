package com.motorph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// This class is responsible for reading the employee attendance file and extracting the attendance records for a specific employee.
public class EmployeeAttendanceFileReader {
    public final String filename = "/home/johnpaul/Documents/motorph/src/main/resources/AttendancerecordmotorPhversion2.2.txt"; // Stores the fixed path for the attendance data file.

    public List<AttendanceRecord> readEmployeeAttendanceFile(String empId, String filename, int month, int year) { // : This is the primary method, responsible for: reading the attendance data file, extracting the attendance records for a specific employee, and returning the extracted records.
        List<AttendanceRecord> attendanceRecords = new ArrayList<>(); //Acts as a simple data container to store the details of a single attendance record.

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine(); // Skip header now

            String line;
            // Validation flag just to make sure it will say if no records are found
            boolean foundRecordsForMonth = false;

            while ((line = reader.readLine()) !=null) {
                String[] data = line.split(",");

                if (data[0].equals(empId)) {
                    LocalDate date = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("M/d/yyyy"));
                    LocalTime timeIn = LocalTime.parse(data[4]);
                    LocalTime timeOut = LocalTime.parse(data[5]);

                    if (date.getMonthValue() == month && date.getYear() == year) {
                        //Added the Lunch break deduction 1 hour
                        Duration duration = Duration.between(timeIn, timeOut).minusMinutes(60);
                        long minutesWorked = duration.toMinutes();
                        //Found a matching record
                        System.out.println("Employee ID: " + empId + " Date: " + date + " Time In: " + timeIn + " Time Out: " + timeOut + " Minutes Worked: " + minutesWorked);
                        attendanceRecords.add(new AttendanceRecord(empId, date, timeIn, timeOut, minutesWorked));

                        // Set the flag to true
                        foundRecordsForMonth = true;
                    }
                }
            }
            // After the loop, check the flag
            if (!foundRecordsForMonth) {
                System.out.println("No attendance records found for employee ID " + empId + " in " + month + "/" + year);
            }
        } catch (IOException e) {
            System.out.println("Error: File not found at " + filename);
        }
        return attendanceRecords;

    }

}

// Simple class to hold attendance data
class AttendanceRecord {
    public String employeeId;
    public LocalDate date;
    public LocalTime timeIn;
    public LocalTime timeOut;
    public long minutesWorked;

    // Constructor
    public AttendanceRecord(String employeeId, LocalDate date, LocalTime timeIn, LocalTime timeOut, long minutesWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.minutesWorked = minutesWorked;
    }
}