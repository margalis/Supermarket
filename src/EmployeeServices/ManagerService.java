package EmployeeServices;

import Comparators.SalaryComparator;
import Employees.Assistant;
import Employees.Cashier;
import Employees.Manager;

import java.util.ArrayList;
import java.util.Collections;

public class ManagerService {

    public static Manager ManagerConverter(String fileText) {
        //Mariam Galstyan,3, QuarteTime,150$, V
        String[] current = fileText.split("\\s*,\\s*");
        Manager as = new Manager();
        as.setFullName(current[0]);
        as.setSalary(Double.parseDouble(current[1]));
        as.setWorkExperience(Integer.parseInt(current[2]));
        as.setWorkHours(current[3].charAt(0));
        as.setAvailable((current[4]) == "V");
        return as;
    }
}
