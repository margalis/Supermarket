package EmployeeServices;

import Comparators.PriceComparator;
import Comparators.SalaryComparator;

import Comparators.WorkExpComparator;
import Employees.Assistant;
import Employees.Employee;
import Products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EmployeeService {
   //1
    public static ArrayList<Employee> getAvailables(Employee[] employees){
        ArrayList<Employee> ms = new ArrayList<>() ;
        for(Employee m: employees){
            if(!m.isAvailable()){
                ms.add(m);
            }
        }
        return ms;
    }
    //2.
    public static Employee getMaxSalary(Employee[] employees){
        ArrayList<Employee> as = new ArrayList<>() ;
        for(Employee a : employees){
            as.add(a);
        }
        return Collections.max(as,new SalaryComparator());
    }
    //3
    public static ArrayList<Employee> sortBySalary(Employee[] products) {
        ArrayList<Employee> r = new ArrayList<>(Arrays.asList(products));
        Collections.sort(r, new SalaryComparator().reversed());
        return r;
    }
    //4
    public static void sortByWorkExp(Employee[] products) {
        ArrayList<Employee> r = new ArrayList<>(Arrays.asList(products));
        Collections.sort(r, new WorkExpComparator());
        for( Employee e: r){
            e.printInfo();
            System.out.println();
        }
    }
}
