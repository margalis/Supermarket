package main;

import EmployeeServices.AssistantService;
import EmployeeServices.CashierService;
import EmployeeServices.EmployeeService;
import Employees.Assistant;
import Employees.Cashier;
import Employees.Employee;
import Market.Market;
import ProductServices.*;
import Products.Books.Book;
import Products.Books.Fiction;
import Products.Books.SchoolTextBook;
import Products.Product;
import Producer.Producer;
import FileServicce.FileService;
import Products.Technology.Computer;
import Products.Technology.Technology;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static ProductServices.ComputerService.ComputerConverter;
import static ProductServices.FictionService.FictionConverter;
import static ProductServices.SchoolTextBookService.STBConverter;

public class Test {
    public static void main(String[] args) throws Exception{
        // FileService.createFolder("Files\\ProductsFolder\\"); //done
        // FileService.createFile("Files\\ProductsFolder\\","schooltextbookfile.txt");
        // FileService.write("Files\\ProductsFolder\\schooltextbookfile.txt","\nZangak, Abovyan_St 12/13,
        //Publishing_Company;MathAnalizi_Tarrer; 45.2; Armen_Martirosyan; Armenian; 450; Mathematics; 11");

        String[] sTBstrings = FileService.readLines("Files\\ProductsFolder\\schooltextbookfile.txt");
        SchoolTextBook[] sTBs = new SchoolTextBook[sTBstrings.length];
        for (int i = 0; i < sTBstrings.length; ++i) {
            sTBs[i] = STBConverter(sTBstrings[i]);
        }
        String[] FcTstrings = FileService.readLines("Files\\ProductsFolder\\fictionbookfile");
        Fiction[] fcts = new Fiction[FcTstrings.length];
        for (int i = 0; i < FcTstrings.length; ++i) {
            fcts[i] = FictionConverter(FcTstrings[i]);
        }
        String[] cmpStrings = FileService.readLines("Files\\ProductsFolder\\computerfile");
        Computer[] cmps = new Computer[cmpStrings.length];
        for (int i = 0; i < cmpStrings.length; ++i) {
            cmps[i] = ComputerConverter(cmpStrings[i]);
        }
        String[] asStrings = FileService.readLines("Files\\ProductsFolder\\assistantfile");
        Assistant[] assistants = new Assistant[asStrings.length];
        for (int i = 0; i < assistants.length; ++i) {
            assistants[i] = AssistantService.AssistantConverter(asStrings[i]);
        }
        String[] chStrings = FileService.readLines("Files\\ProductsFolder\\cashierfile");
        Cashier[] cashiers = new Cashier[chStrings.length];
        for (int i = 0; i < cashiers.length; ++i) {
            cashiers[i] = CashierService.CashierConverter(chStrings[i]);
        }

        //mmarket
        ArrayList<Product> products = new ArrayList<Product>();
        products.addAll(Arrays.asList(fcts));
        products.addAll(Arrays.asList(cmps));
        products.addAll(Arrays.asList(sTBs));
        Product productsArray[] = new Product[products.size()];
        productsArray = products.toArray(productsArray);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(cashiers));
        employees.addAll(Arrays.asList(assistants));
        Employee employeesArray[] = new Employee[employees.size()];
        employeesArray = employees.toArray(employeesArray);

        Market MMarket = new Market(productsArray, productsArray.length, employeesArray,
                employeesArray.length, "MMarket", "Yerevan Armenia Mantashian st7/8");


        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Store Menu ");
        boolean isActive = true;
        while (isActive) {
            System.out.println("Enter Number");
            System.out.println("1. Working with products ");
            System.out.println("2. Working with employees");
            System.out.println("3. Working with Market overall information");
            System.out.println("4. exit");
            int c = s.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Welcome to products");
                    boolean isActive1 = true;
                    while (isActive1) {
                        System.out.println("Enter Number");
                        System.out.println("1. Working with Books ");
                        System.out.println("2. Working with Tech/hly vor Computers");
                        System.out.println("3. exit");
                        int c1 = s.nextInt();
                        switch (c1) {
                            case 1:
                                System.out.println("You;ve entered Books section,choose what to work with");
                                boolean isActive2 = true;
                                while (isActive2) {
                                    System.out.println("Enter Number");
                                    System.out.println("1. Working with SchoolTextBooks");//TB-nerin arandzin f-al chka
                                    System.out.println("2. Working with FictionBooks");
                                    System.out.println("3. Working with all Books");
                                    System.out.println("4. exit");
                                    int c2 = s.nextInt();
                                    switch (c2) {
                                        case 1:
                                            System.out.println("School TextBooks");
                                            boolean isActive3 = true;
                                            while (isActive3) {
                                                System.out.println("Enter Number");
                                                System.out.println("1.getBooksFor8thGrade");
                                                System.out.println("2. getBMaxPricedMathBook");
                                                System.out.println("3. Print Books for English by Author");
                                                System.out.println("4. getPriceOfPhysicsBookMinPageCount");
                                                System.out.println("5. exit");
                                                int c3 = s.nextInt();
                                                switch (c3) {
                                                    case 1:
                                                        ArrayList<SchoolTextBook> cas1 =
                                                                SchoolTextBookService.getBooksFor8thGrade(sTBs);
                                                        for (SchoolTextBook stb : cas1) {
                                                            stb.printInfo();
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println(SchoolTextBookService.
                                                                getBMaxPricedMathBook(sTBs));
                                                        break;
                                                    case 3:
                                                        System.out.println("Author name` ");
                                                        String avtor = s.next();
                                                        SchoolTextBookService.PrintBooksforEnglishbyAuthor(sTBs, avtor);
                                                        break;
                                                    case 4:
                                                        System.out.println(SchoolTextBookService.
                                                                getPriceOfPhysicsBookMinPageCount(sTBs));
                                                        break;
                                                    case 5:
                                                        isActive3 = false;
                                                        break;
                                                    default:
                                                        System.out.println("Invalid command number!");
                                                }

                                            }
                                            break;

                                        case 2:
                                            System.out.println("Fiction Books");
                                            boolean isActive4 = true;
                                            while (isActive4) {
                                                System.out.println("Enter Number");
                                                System.out.println("1.getDetectives");
                                                System.out.println("2. printHorrorWithAgeLimit16+");
                                                System.out.println("3. getFantasyBooksByAuthor");
                                                System.out.println("4. sortByAgeLimit");
                                                System.out.println("5. printMinAgeLimitZangakFantasyBook");
                                                System.out.println("6. printPageCountsOfMangas12plus");
                                                System.out.println("7. exit");
                                                int c3 = s.nextInt();
                                                switch (c3) {
                                                    case 1:
                                                        ArrayList<Fiction> cas1 =
                                                                FictionService.getDetectives(fcts);
                                                        for (Fiction f : cas1) {
                                                            f.printInfo();
                                                        }
                                                        break;
                                                    case 2:
                                                        FictionService.printHistoricalWithAgeLimit(fcts);
                                                        break;
                                                    case 3:
                                                        System.out.println("Author name` ");
                                                        String avtor = s.next();
                                                        for (Fiction f : FictionService.
                                                                getFantasyBooksByAuthor(fcts, avtor))
                                                            f.printInfo();

                                                        break;
                                                    case 4:
                                                        ArrayList<Fiction> cas4 =
                                                                FictionService.sortByAgeLimit(fcts);
                                                        for (Fiction f : cas4) {
                                                            f.printInfo();
                                                        }
                                                        break;
                                                    case 5:
                                                        FictionService.printMinAgeLimitZangakFantasyBook(fcts);
                                                        break;
                                                    case 6:
                                                        FictionService.printPageCountsOfMangas12plus(fcts);
                                                        break;
                                                    case 7:
                                                        isActive4 = false;
                                                        break;
                                                    default:
                                                        System.out.println("Invalid command number!");
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("All Books");
                                            ArrayList<Book> books = new ArrayList<>();
                                            books.addAll(Arrays.asList(fcts));
                                            books.addAll(Arrays.asList(sTBs));
                                            Book booksArray[] = new Book[books.size()];
                                            booksArray = books.toArray(booksArray);
                                            boolean isActive5 = true;
                                            while (isActive5) {
                                                System.out.println("Enter Number");
                                                System.out.println("1.PrintZangakBooks");
                                                System.out.println("2.orderByPageCount");
                                                System.out.println("3. printEnglishs");
                                                System.out.println("4. PrintNamesOfAuthorsBooks");
                                                System.out.println("5. exit");
                                                int c4 = s.nextInt();
                                                switch (c4) {
                                                    case 1:
                                                        BooksService.PrintZangakBooks(booksArray);
                                                        break;
                                                    case 2:
                                                        BooksService.orderByPageCount(booksArray);

                                                        break;
                                                    case 3:
                                                        BooksService.printEnglishs(booksArray);
                                                        break;
                                                    case 4:
                                                        String avtor = s.next();
                                                        BooksService.PrintNamesOfAuthorsBooks(booksArray, avtor);
                                                        break;
                                                    case 5:
                                                        isActive5 = false;
                                                        break;
                                                    default:
                                                        System.out.println("Invalid command number!");
                                                }
                                            }
                                            break;
                                        case 4:
                                            isActive2 = false;
                                            break;
                                        default:
                                            System.out.println("Invalid command number!");

                                    }
                                }

                                break;
                            case 2:
                                System.out.println("You;ve entered Computers section,choose what to work with");
                                boolean isActiveComp = true;
                                while (isActiveComp) {
                                    System.out.println("1.HowManyAppleLaptopsAreAvailable");
                                    System.out.println("2.sortByPriceViaMemory");
                                    System.out.println("3.getCountOfMacBooks");
                                    System.out.println("4.getLaptopsWith4plusRAM");
                                    System.out.println("5.getModelsOfWindows4CoreDesktops");
                                    System.out.println("6. exit");
                                    int B = s.nextInt();
                                    switch (B) {
                                        case 1:
                                            System.out.println(ComputerService.HowManyAppleLaptopsAreAvailable(cmps));
                                            break;
                                        case 2:
                                            ArrayList<Computer> sorted = ComputerService.sortByPriceViaMemory(cmps);
                                            for (Computer computer : sorted) {
                                                computer.printInfo();
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Count of MacBooks "
                                                    + ComputerService.getCountOfMacBooks(cmps));
                                            break;
                                        case 4:
                                            ArrayList<Computer> laptops =
                                                    ComputerService.getLaptopsWith4plusRAM(cmps);
                                            for (Computer computer : laptops) {
                                                System.out.println(computer.getName());
                                            }
                                            break;
                                        case 5:
                                            ArrayList<String> win4CoreModels =
                                                    ComputerService.getModelsOfWindows4CoreMonitors(cmps);
                                            System.out.println(win4CoreModels);
                                            //dont know
                                            break;
                                        case 6:
                                            isActiveComp = false;
                                            break;
                                        default:
                                            System.out.println("Invalid command number!");
                                    }
                                }

                                break;
                            case 3:
                                isActive1 = false;
                                break;
                            default:
                                System.out.println("Invalid command number!");
                        }
                    }

                    break;
                case 2:
                    System.out.println("Welcome to Employees Informative center");
                    boolean isActiveE =true;
                    while(isActiveE){
                        System.out.println("Enter Number");
                        System.out.println("1.Assistants ");
                        System.out.println("2. Cashiers");
                        System.out.println("3. all Employees");
                        System.out.println("4. exit");
                        int c1 = s.nextInt();
                        switch (c1) {
                            case 1:
                                System.out.println("Assistants");
                                boolean isActiveAS =true;
                                while(isActiveAS){
                                    System.out.println("Enter Number");
                                    System.out.println("1..printDepAssistants");
                                    System.out.println("2.printAssistantNamesFromBooks");
                                    System.out.println("3.MinSalaryAssistant");
                                    System.out.println("4.PartTimeBooksAssistantsNTasks");
                                    System.out.println("5. SortByWorkExp");
                                    System.out.println("6.Exit");
                                    int cAss = s.nextInt();
                                    switch (cAss){
                                        case 1:
                                            System.out.println("Enter departement name");
                                            String dep =s.next();
                                            AssistantService.printDepAssistants(assistants,dep);
                                            break;
                                        case 2:
                                            AssistantService.printAssistantNamesFromBooks(assistants);
                                            break;
                                        case 3:
                                            System.out.println("Enter departement name");
                                            String dep2 =s.next();
                                            AssistantService.MinSalaryAssistant(assistants,dep2).printInfo();
                                            break;
                                        case 4:
                                            AssistantService.PartTimeBooksAssistantsNTasks(assistants);
                                            break;
                                        case 5:
                                            ArrayList<Assistant> sord = AssistantService.SortByWorkExpComps(assistants);
                                            for(Assistant a: sord){
                                                System.out.println(a.getFullName());
                                            }
                                            break;
                                        case 6:
                                            isActiveAS = false;
                                            break;
                                        default:
                                            System.out.println("Invalid command number!");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Cashiers");
                                boolean isActiveCS= true ;
                                while (isActiveCS) {
                                    System.out.println("Enter Number");
                                    System.out.println("1..printCashierNames");
                                    System.out.println("2.getDifWorkHoursCashiers");
                                    System.out.println("3. CountOfFTCashiersAtNCash");
                                    System.out.println("4.Exit");
                                    int cCs = s.nextInt();
                                    switch (cCs){
                                        case 1:
                                            //5rdniny
                                            CashierService.printCashierNames(cashiers,2);
                                            break;
                                        case 2:

                                            ArrayList<Cashier> pTC =CashierService.
                                                    getDifWorkHoursCashiers(cashiers,'F');
                                            System.out.println(pTC);
                                            break;
                                        case 3:
                                            System.out.println(CashierService.CountOfFTCashiersAtNCash(cashiers,3));
                                            break;
                                        case 4:
                                            isActiveCS = false;
                                            break;
                                        default:
                                            System.out.println("Invalid command number!");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("ALL employees");
                                boolean isActiveEM= true ;
                                while(isActiveEM){
                                    System.out.println("Enter Number");
                                    System.out.println("1.getMaxSalary");
                                    System.out.println("2.sortBySalary desc");
                                    System.out.println("3.sortByWorkExp");
                                    System.out.println("4. Exit");
                                    int cAllEmp = s.nextInt();
                                    switch (cAllEmp){
                                        case 1:
                                            EmployeeService.getMaxSalary(employeesArray).printInfo();
                                            break;
                                        case 2:
                                            ArrayList<Employee> sortedEmps =EmployeeService.
                                                   sortBySalary(employeesArray);
                                            for(Employee e :sortedEmps ){
                                                System.out.println(e.getFullName());
                                                System.out.println();
                                            }
                                            break;
                                        case 3:
                                            EmployeeService.sortByWorkExp(employeesArray);
                                            break;
                                        case 4:
                                            isActiveEM = false;
                                            break;
                                        default:
                                            System.out.println("Invalid command number!");
                                    }

                                }
                                break;
                            case 4:
                                isActiveE = false;
                                break;
                            default:
                                System.out.println("Invalid command number!");

                        }
                    }
                    break;
                case 3:
                    System.out.println("Welcome to Market info");
                    boolean isActiveM = true;
                    while (isActiveM) {
                        System.out.println("Enter number");
                        System.out.println("1.AreThereProducts");
                        System.out.println("2.sortProductsByPrice");
                        System.out.println("3.getAvailableEmployees");
                        System.out.println("4.AreThereEmployess");
                        System.out.println("5.printALlEmployeeNamesand Tasks");
                        System.out.println("6.printProducts.");
                        System.out.println("7.getAvailableProducts");
                        System.out.println("8. exit");
                        int cMM = s.nextInt();
                        switch (cMM) {
                            case 1:
                                System.out.println(MMarket.AreThereProducts());
                                break;
                            case 2:
                                for (Product product: MMarket.sortProductsByPrice()) {
                                    product.printInfo();
                                }
                                break;
                            case 3:
                                MMarket.getAvailableEmployees();
                                break;
                            case 4:
                                System.out.println(MMarket.AreThereEmployees());
                                break;
                            case 5:
                                MMarket.printEmployeeNamesAndTasks();
                                break;
                            case 6:
                                MMarket.printProducts();
                            case 7:
                                System.out.println(MMarket.getAvailableProducts());
                                System.out.println();
                                break;
                            case 8:
                                isActiveM = false;
                                break;
                            default:
                                System.out.println("Invalid command number!");
                        }
                    }
                    break;
                case 4:
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid command number!");
            }

        }

        System.out.println("Generated Products Count " + Product.countOfProductsGenerated);
        System.out.println("Where " + Book.BookCount +" are Books");
        System.out.println("And "+ Technology.TechCount +" are Tech products");
        //additional MARKET MENU
       /*
        //MMarket 8
        /*productsArray=ProductService.sortByPrice(productsArray).toArray(productsArray);
        for(Product pr: productsArray){
            System.out.println(pr.getName() + " " +pr.getPrice());
        }*/
        //MMarket9  sra hamar nor array sarqel anpayman kam vapshe arraylistov stanal
       /* productsArray=ProductService.MadeByCertainProducerType(productsArray,"Company").toArray(productsArray);
        for(int i =0 ; i<5 ; ++i){
            System.out.println(productsArray[i].getName());
        } * /
       //Employee Servicen el
      */

    }
}
