package EmployeeServices;

import Comparators.SalaryComparator;
import Comparators.WorkExpComparator;
import Employees.Assistant;
import Products.Books.SchoolTextBook;

import java.util.ArrayList;
import java.util.Collections;

import static ProducerService.ProducerService.ProducerConverter;

public class AssistantService extends EmployeeService{

    //1
    public static void printAssistantNamesFromBooks(Assistant[] assistants) {
        for (Assistant a : assistants) {
           if(a.getDepartmentName().equalsIgnoreCase("Books"))
           {   System.out.println(a.getFullName());
            System.out.println();}
        }
    }

    //2
    public static void printDepAssistants(Assistant[] assistants, String department) {
        for (Assistant a : assistants) {
            if (a.getDepartmentName().equalsIgnoreCase(department))
            {  a.printInfo();
            System.out.println();}
        }
    }

    //3
    public static Assistant MinSalaryAssistant(Assistant[] assistants, String department) {
        ArrayList<Assistant> as = new ArrayList<>();
        for (Assistant a : assistants) {
            if (a.getDepartmentName().equalsIgnoreCase(department)) as.add(a);
        }
        return Collections.min(as, new SalaryComparator());
    }

    //4
    public static void PartTimeBooksAssistantsNTasks(Assistant[] assistants) {
        for (Assistant a : assistants) {
            if (a.getDepartmentName().equalsIgnoreCase("Books") && a.getWorkHours() == 'P')
            { a.printInfo();
                System.out.println("\n");
                a.Tasks();
                System.out.println();
            }
        }
    }

    //5
    public static ArrayList<Assistant> SortByWorkExpComps(Assistant[] assistants) {
        ArrayList<Assistant> as = new ArrayList<>();
        for (Assistant a : assistants) {
            if (a.getDepartmentName().equalsIgnoreCase("Tech")) as.add(a);
        }
        Collections.sort(as, new WorkExpComparator().reversed());
        return as;
    }

    public static Assistant AssistantConverter(String fileText) {
        //Mariam Galstyan,3, QuarteTime,150$,Books, V
        String[] current = fileText.split("\\s*,\\s*");
        Assistant as = new Assistant(current[4]);
        as.setFullName(current[0]);
        as.setSalary(Double.parseDouble(current[3]));
        as.setWorkExperience(Integer.parseInt(current[1]));
        as.setWorkHours(current[2].charAt(0));
        as.setAvailable(current[5].charAt(0) == 'V');
        return as;
    }
}
