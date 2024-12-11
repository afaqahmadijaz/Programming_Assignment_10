//********************************************************************
//
//  Author:       Afaq Ahmad
//
//  Program #:    10
//
//  File Name:    Program10.java
//
//  Course:       ITSE 2321 Object-Oriented Programming
//
//  Due Date:     December 13th
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      Chapter 1 - 9, 11, 14, and 15: Objects, Classes, Methods, Exceptions, Strings, and Files
//
//  Description:  This program calculates the monthly pay for non-exempt hourly employees.
//                It will prompt for first name, last name, SSN, pay rate, and weekly hours for 4 weeks.
//                It computes regular pay, overtime pay, gross pay, and then applies tax using the given tax table.
//                It repeats until the user enters "No" or "no" for the first name.
//
//********************************************************************

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program10 {
    //***************************************************************
    //
    //  Method:       main
    //
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void main(String[] args) {

        developerInfo();
        runProgram();

    } // End of the main method

    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void developerInfo() {
        System.out.println("Name:     Afaq Ahmad");
        System.out.println("Course:   ITSE 2321 Object-Oriented Programming");
        System.out.println("Program:  TEN");
        System.out.println("Due Date: December 13th\n");
    } // End of the developerInfo method

    public static void runProgram() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter employee's first name (or 'No'/'no' to end): ");
            String firstName = input.nextLine().trim();

            if (firstName.equalsIgnoreCase("No"))
                break;

            System.out.print("Enter employee's last name: ");
            String lastName = input.nextLine().trim();

            double payRate = 0.0;
            boolean validRate = false;
            while (!validRate) {
                System.out.print("Enter employee's hourly pay rate: ");
                try {
                    payRate = Double.parseDouble(input.nextLine().trim());
                    validRate = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }

            System.out.print("Enter employee's SSN (format XXX-XX-XXXX): ");
            String SSN = input.nextLine().trim();

            HourlyEmployee emp = null;
            try {
                emp = new HourlyEmployee(firstName, lastName, SSN, payRate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please re-enter the employee's information.");
                continue; // go back and ask again
            }

            // Get hours worked for 4 weeks
            for (int week = 1; week <= 4; week++) {
                double hours = 0.0;
                boolean validHours = false;
                while (!validHours) {
                    System.out.print("Enter hours worked for week " + week + ": ");
                    try {
                        hours = Double.parseDouble(input.nextLine().trim());
                        if (hours < 0)
                            throw new IllegalArgumentException("Hours cannot be negative.");
                        validHours = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Please try again.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                emp.setTotalHoursWorked(hours);
            }

            // Print the results
            System.out.println();
            System.out.println(emp.toString());

        } // end while

        System.out.println("Program ended.");
    }
}