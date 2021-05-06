package Employees;

import Exceptions.NegativeValueException;

public class Cashier extends Employee {
    private int CashNumber; //te vor kassayi mot a kangnum

    public Cashier(int cashNumber) {
        super();
        if (cashNumber < 0) {
            System.out.println("CashNumber");
            throw new NegativeValueException(cashNumber);
        }
        this.CashNumber = cashNumber;
    }

    public int getCashNumber() {
        return CashNumber;
    }

    @Override
    public void printInfo() {
        System.out.println("Cashiers");
        super.printInfo();
        System.out.printf("Cash number: %d", CashNumber);
    }

    public void Tasks() {
        System.out.println("Be Nice to clients");
        System.out.println("Do all cash computing");
        System.out.println("Give HDMs to clients");
        System.out.println("Daily report to Manager ");
    }

    public void printSchedule() {
        //TODO
    }

    public void Work() {
        System.out.println("Managed to do something");
        //TODO
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Cashier{").
                append("CashNumber=").append(CashNumber).append('}').toString();
    }
}
