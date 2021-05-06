package EmployeeServices;

import Employees.Assistant;
import Employees.Cashier;
import Exceptions.NegativeValueException;
import Exceptions.WrongEmployeeWorkHoursException;

import java.util.ArrayList;

public class CashierService extends EmployeeService{

    //11.	get full names of all cashiers that work at  2nd cash
    public static void printCashierNames(Cashier[] cashiers,int cashNumber) {
        for (Cashier c : cashiers) {
            if (c.getCashNumber() == cashNumber)
            { System.out.println(c.getFullName());
                c.Tasks(); }
        }
    }
    //2.get part time cashiers
    public static ArrayList<Cashier> getDifWorkHoursCashiers(Cashier[] cashiers,char workHours){
       if(workHours != 'P' && workHours != 'F' && workHours != 'Q'){
           throw new WrongEmployeeWorkHoursException(workHours);
       }
        ArrayList<Cashier> cs = new ArrayList<>() ;
        for(Cashier c : cashiers){
            if(c.getWorkHours()==workHours){
                cs.add(c);
            }
        }
        return cs;
    }
    //3. count of fulltime cashiers that work at certain numbered cash machine
    public static int  CountOfFTCashiersAtNCash(Cashier[] cashiers,int N){
        if(N<0){
            throw new NegativeValueException(N);
        }
        int count = 0 ;
        for(Cashier c : cashiers){
            if(c.getWorkHours()=='F' && c.getCashNumber()==N){
               count++;
            }
        }
        return  count;
    }

    public static Cashier CashierConverter(String fileText) {
        //Mariam Galstyan,3, QuarteTime,150$,8, V
        String[] current = fileText.split("\\s*,\\s*");
        Cashier as = new Cashier(Integer.parseInt(current[4]));
        as.setFullName(current[0]);
        as.setSalary(Double.parseDouble(current[3]));
        as.setWorkExperience(Integer.parseInt(current[1]));
        as.setWorkHours(current[2].charAt(0));
        as.setAvailable(current[5].charAt(0)=='V');
        return as;
    }
}
