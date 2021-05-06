package ProductServices;

import Comparators.PriceComparator;
import Comparators.SalaryComparator;
import Comparators.WorkExpComparator;
import ProducerService.ProducerService;
import Products.Books.Fiction;
import Products.Technology.Computer;
import Producer.Producer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static ProducerService.ProducerService.ProducerConverter;

public class ComputerService extends ProductService {
    public static Computer createComputer(Producer pr){
            // amen depqum
        Scanner s= new Scanner(System.in);
        System.out.println("Write with '_' ");
        System.out.println("Enter Product Name");
        String name =s.next();
        System.out.println("Enter Price");
        double price =s.nextDouble();
        System.out.println("Is it available");
        boolean b = (s.next().equalsIgnoreCase("yes"));

        System.out.println("Enter RAM");
        int RAM= s.nextInt();
        System.out.println("Enter disk memory");
        int diskMem= s.nextInt();
        System.out.println("Enter Model: ");
        String model = s.next();
        System.out.println("Enter OS: ");
        String OS = s.next();
        System.out.println("Enter production year");
        int prYear = s.nextInt();

        System.out.println("Enter TYPEl: ");
        String type = s.next();
        System.out.println("Enter number of cores: ");
        int cores= s.nextInt();
        Computer c = new Computer(pr,type,cores);
        c.setName(name);
        c.setPrice(price);
        c.setAvailable(b);
        c.setModel(model);
        c.setDISK_Memory(diskMem);
        c.setOS(OS);
        c.setRAM(RAM);
        c.setPrddYear(prYear);
        return c;
    }

    //1.HowManyAppleLaptopsAreAvailable
    public static int HowManyAppleLaptopsAreAvailable(Computer[] computers){
        int counter= 0 ;
        for(Computer c: computers){
            if(  c.isAvailable() && c.getMAKER().getName().equalsIgnoreCase("Apple.") &&
                   c.getType().equalsIgnoreCase("NoteBook"))
            {   counter++;}
        }
        return counter;
    }
    //2.sort comps with 120 gb memory by price
    public static ArrayList<Computer> sortByPriceViaMemory(Computer[] computers){
        ArrayList<Computer> cmp = new ArrayList<>();
        for(Computer c : computers){
            if(c.getDISK_Memory()==256){
                cmp.add(c);
            }
        }
        Collections.sort(cmp,new PriceComparator());
        return cmp;
    }
    //3.	get count of macs
    public static int getCountOfMacBooks(Computer[] computers){
        int counter=0 ;
        for(Computer c :computers){
            if(c.getOS().equalsIgnoreCase("MacOS")){
                counter++;
            }
        }
        return counter;
    }
    //4.laptops with RAM more than 8gb
    public static ArrayList<Computer> getLaptopsWith4plusRAM(Computer[] computers){
        ArrayList<Computer> cmp = new ArrayList<>();
        for(Computer c : computers){
            if(c.getRAM()>=8 && c.getType().equalsIgnoreCase("NoteBook")){
                cmp.add(c);
            }
        }
        return cmp;
    }
    //5 models of monitors that have OS=Windows and 4cores
    public static ArrayList<String> getModelsOfWindows4CoreMonitors(Computer[] computers){
        ArrayList<String> Modelios= new ArrayList<>();
        for(Computer c : computers){
            if(c.getNumberOfCores()==4 && c.getOS().equalsIgnoreCase("Windows")
                    && c.getType().equalsIgnoreCase("Desktop")){
             Modelios.add(c.getModel());
            }
        }
        return Modelios;
    }

    public static Computer ComputerConverter(String fileText) { // es stringy uni hetevyal tesqy
        String[] current = fileText.split("\\s*;\\s*");
       //Producer producer,String type, int numberOfCores
        Computer cmp = new Computer(ProducerConverter(current[0]),
                current[8],
                Integer.parseInt(current[9]));
        cmp.setName(current[1]);
        cmp.setModel(current[2]);
        cmp.setPrice(Double.parseDouble(current[3]));
        cmp.setRAM(Integer.parseInt(current[4]));
        cmp.setDISK_Memory(Integer.parseInt(current[5]));
        cmp.setOS(current[6]);
        cmp.setPrddYear(Integer.parseInt(current[7]));
        cmp.setAvailable(current[10].charAt(0)=='V');
        return cmp;
    }

}
