package Employees;

import Exceptions.WrongEmployeeWorkHoursException;
import Exceptions.InvalidStringException;
import Exceptions.NegativeValueException;

public abstract class Employee implements IEmployeeFunctionality {
    private String fullName; // nonEmpty
    private int workExperience;  // >=0
    private boolean isAvailable;
    private char WorkHours; // part time/ full time p/f
    private double Salary; // > 0

    public void printInfo() {
        System.out.printf("Full Name: %s , ", fullName);
        System.out.printf("Work Experience: %d years, ", workExperience);
        System.out.println(isAvailable ? "is Available" : "currently not working");
        System.out.println(WorkHours == 'P' ? "Part Time" : (WorkHours == 'F') ?
                "Full Time" : "Quarter Time" + "worker");
        System.out.printf("Salary: %.1f $", Salary);
        System.out.println();

    }

    public abstract void Tasks();

    public abstract void printSchedule();

    public abstract void Work();


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.isEmpty() || fullName.equals(null) || fullName.trim().isEmpty()) {
            System.out.println("Employees full name is invalid");
            throw new InvalidStringException(fullName);
        }
        this.fullName = fullName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        if (workExperience >= 0)
            this.workExperience = workExperience;
        else {
            System.out.println("Employees work experience can't be negative");
            throw new NegativeValueException(workExperience);
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public char getWorkHours() {
        return WorkHours;
    }

    public void setWorkHours(char workHours) {
        if (workHours == 'P' || workHours == 'F' || workHours == 'Q') {
            WorkHours = workHours;
        } else {
            throw new WrongEmployeeWorkHoursException(workHours);
        }
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Salary");
            throw new NegativeValueException(salary);
        }
        Salary = salary;
    }

    @Override
    public String toString() {

        return new StringBuilder().append("Employee{").
                append("fullName='").append(fullName).append('\'').
                append(", workExperience=").append(workExperience).
                append(", isAvailable=").append(isAvailable).
                append(", WorkHours=").append(WorkHours).
                append(", Salary=").append(Salary).append('}').toString();
    }
}
