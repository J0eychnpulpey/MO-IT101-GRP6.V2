package com.motorph;

// This class is the main class of the program. It displays the main menu and processes the user's choice.
/*encapsulates the logic of processing the user's choice within the processOption method. This hides 
the implementation details (the switch statement), and other parts of your program simply
call processOption without needing to know how it internally handles different choices. */
// This is Group 6 Version 2 (well version 1 is accidentally deleted due to a wrong git command Haha)

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        displayMainmenu();
        input.close();
    }
        
    private static void displayMainmenu() {
        System.out.println("************************************************");
        System.out.println("      Motor PH Main Menu Group 6 Version.2      ");
        System.out.println("************************************************");
        System.out.println("1: Show Employee Profile                        ");
        System.out.println("2: Calculate Gross Wage                         ");
        System.out.println("3: Calculate Net Wage                           ");
        System.out.println("************************************************");
    
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        
        processOption(choice);
        input.close();
    } 
    
    private static void processOption(int choice) {
        switch(choice) {
            case 1:
                Case1EmployeeProfilemethod.showEmployeeProfile();
                break;
            case 2:
                Case2GrossWage.showGrossWage();
                break;
            case 3:
                Case3NetWage.ShowNetWage();
                break;
            default:
                System.out.println("Invalid choice");
                displayMainmenu(); // Return to the main menu if the user enters an invalid choice
        }
    }
}

