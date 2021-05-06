package Employees;

public class Manager extends Employee {
    public Manager() {
        super();
    }
    @Override
    public void printInfo() {
        System.out.println("Managers \n");
        super.printInfo();
    }

    public void Tasks() {
        System.out.println("Be Nice to clients");
        System.out.println("Check the needs of employees");
        System.out.println("Manage the workflow");
        System.out.println("Daily reports");
    }

    public void printSchedule() {
        //TODO
    }

    public void Work() {
        //TODO
    }


}
