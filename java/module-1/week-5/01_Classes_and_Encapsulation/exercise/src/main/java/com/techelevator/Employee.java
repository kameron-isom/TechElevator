package com.techelevator;

public class Employee {
    // add instance variables

    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    //add getters and setters


    public int getEmployeeId() {
        return employeeId;
    }


    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return lastName + ", "+ firstName;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }




    // add constructors

    public Employee(int employeeId, String firstName, String lastName, double salary){
        this.employeeId= employeeId;
        this.firstName = firstName;
        this.lastName= lastName;
        this.annualSalary= salary;
    }

    //create method called raiseSalary
    public void raiseSalary (double precent){
         double percent = (5.5 * annualSalary)/100;
        annualSalary = annualSalary + percent;
    }
}
