package Employees;

import Exceptions.InvalidStringException;

import static Products.Books.Book.BookCount;
import static Products.Technology.Technology.TechCount;

public class Assistant extends Employee {
    private String DepartmentName; //Books, Tech, Food ,Toys ...

    public Assistant(String departmentName) {
        super();
        if (departmentName.isEmpty() || departmentName.equals(null) ||
                departmentName.trim().isEmpty()) {
            throw new InvalidStringException(departmentName);
        }
        this.DepartmentName = departmentName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    @Override
    public void printInfo() {
        System.out.println("Assistants");
        super.printInfo();
        System.out.printf("Department Name: %s", DepartmentName);
    }

    public void Tasks() {
        System.out.println("Be Nice to clients");
        System.out.println("Check Departments needs");
        System.out.println("Move out of stock items out of available items list");
        System.out.println("Daily report to Manager ");
    }

    public void printSchedule() {
        System.out.println("Default Schedule: ");//esi haves kliner vor arandzin class liner
    }

    public void Work() {
        //maybe I could've make Assistant hierarchy based on department
        if(DepartmentName=="Books"){
            System.out.println("Checking Product quantity of"
                    + DepartmentName+"department");
            System.out.println(BookCount +" items found");
            System.out.println();
        }
        if(DepartmentName=="Technology"){
            System.out.println("Checking Product quantity of"
                    + DepartmentName+"department");
            System.out.println(TechCount +" items found");
            System.out.println();
        }
        //add other functionalities
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).
                append("Assistant{").append("DepartmentName='").
                append(DepartmentName).append('\'').append('}').toString();
    }
}
