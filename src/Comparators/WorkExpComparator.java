package Comparators;

import Employees.Employee;

import java.util.Comparator;

public class WorkExpComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getWorkExperience()>o2.getWorkExperience()){
            return 1;
        }
        if(o1.getWorkExperience()<o2.getWorkExperience()){
            return -1;
        }
        return 0 ;
    }
}
