//********************************************************************
//
//  Developer:    Instructor
//
//  Program #:    Ten
//
//  File Name:    Employee.java
//
//  Course:       ITSE 2321 Objected-Oriented Programming (Java)
//
//  Instructor:   Prof. Fred Kumi
//
//  Description:  Employee class.  Please do NOT modify this Class.
//                If you do, you will not receive credit for Program 10.
//
//********************************************************************

public class Employee extends Object
{
    // Instance variables
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double payRate;

    // Employee default constructor
    public Employee()
    {
        this.firstName = "";
        this.lastName = "";
        this.socialSecurityNumber = "";
        this.payRate = 0.0;
    }

    // Employee constructor
    public Employee(String firstName, String lastName, String SSN, double payRate)
    {
        if (!firstName.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException(
                    "First name should only contain letters");

        if (!lastName.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException(
                    "Last name should only contain letters");

        if (!SSN.matches("\\d{3}-\\d{2}-\\d{4}"))
            throw new IllegalArgumentException(
                    "Social Security Number does not match the following format XXX-XX-XXXX");

        if (payRate <= 0.0)
            throw new IllegalArgumentException("Pay rate must be > 0.0");
        else if (payRate < 7.25)
            payRate = 7.25;

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = SSN;
        this.payRate = payRate;

    } // end constructor

    // Sets the first name.
    public void setFirstName(String firstName)
    {
        if (!firstName.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException(
                    "First name should only contain letters");

        this.firstName = firstName;
    }

    // Sets the last name.
    public void setLastName(String lastName)
    {
        if (!lastName.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException(
                    "Last name should only contain letters");

        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String SSN)
    {
        if (!SSN.matches("\\d{3}-\\d{2}-\\d{4}"))
            throw new IllegalArgumentException(
                    "Social Security Number does not match the following format XXX-XX-XXXX");

        this.socialSecurityNumber = SSN;
    }

    //Sets the pay rate.
    public void setPayRate(double payRate)
    {
        if (payRate <= 0.0)
            throw new IllegalArgumentException("Pay rate must be > 0.0");
        else if (payRate < 7.25)
            this.payRate = 7.25;
        else
            this.payRate = payRate;
    }

    // Gets the first name.
    public String getFirstName()
    {
        return firstName;
    }

    // Gets the last name
    public String getLastName()
    {
        return lastName;
    }

    // Gets the social security number
    public String setSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // Gets the pay rate.
    public double getPayRate()
    {
        return payRate;
    }

    // Returns the String representation of an Employee object.
    @Override // indicates that this method overrides a superclass method
    public String toString()
    {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f",
                "Employee", firstName, lastName,
                "Social Security Number", socialSecurityNumber,
                "Pay rate", payRate);
    }
} // End class Employee
