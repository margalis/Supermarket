package ProductServices;

import Comparators.PriceComparator;
import Comparators.SalaryComparator;
import Employees.Assistant;
import Exceptions.InvalidStringException;
import Producer.Producer;
import ProducerService.ProducerService;
import Products.Books.SchoolTextBook;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static ProducerService.ProducerService.ProducerConverter;

public class SchoolTextBookService extends BooksService{
    //two types of create
    public static SchoolTextBook createSchoolTextBook(Producer pr) {

        Scanner s = new Scanner(System.in);
        System.out.println("Write with '_' ");

        System.out.println("Enter Product Name");
        String name = s.next();

        System.out.println("Enter Price");
        double price = s.nextDouble();

        System.out.println("Is Available");
        boolean av = (s.next()=="yes")?true:false;

        System.out.println("Enter Authors Name ,ie. Derenik_Demirchian: ");
        String author = s.next();

        System.out.println("Enter Subject(ie Math,English,Geography): ");
        String subject = s.next();

        System.out.println("Enter language in which was written: ");
        String lang = s.next();

        System.out.println("Enter count of pages: ");
        int pgcount = s.nextInt();

        System.out.println("Enter Grade [1,12]");
        int grade= s.nextInt();
        SchoolTextBook stb = new SchoolTextBook(pr,subject,grade);
        stb.setName(name);
        stb.setPrice(price);
        stb.setAvailable(av);
        stb.setAuthor(author);
        stb.setLanguage(lang);
        stb.setPageCount(pgcount);
        return stb;
    }
    public static SchoolTextBook createSchoolTextBook() {

        Scanner s = new Scanner(System.in);
        Producer pr = ProducerService.createProducer();

        System.out.println("Enter Product Name");
        String name = s.next();

        System.out.println("Enter Price");
        double price = s.nextDouble();

        System.out.println("Is Available");
        boolean av = (s.next()=="yes")?true:false;

        System.out.println("Enter Authors Name ,ie. Derenik_Demirchian: ");
        String author = s.next();

        System.out.println("Enter Subject(ie Math,English,Geography): ");
        String subject = s.next();

        System.out.println("Enter language in which was written: ");
        String lang = s.next();

        System.out.println("Enter count of pages: ");
        int pgcount = s.nextInt();

        System.out.println("Enter Grade [1,12]");
        int grade= s.nextInt();
        SchoolTextBook stb = new SchoolTextBook(pr,subject,grade);
        stb.setName(name);
        stb.setPrice(price);
        stb.setAvailable(av);
        stb.setAuthor(author);
        stb.setLanguage(lang);
        stb.setPageCount(pgcount);
        return stb;
    }

    public static SchoolTextBook STBConverter(String fileText) { // es stringy uni hetevyal tesqy
        String[] current= fileText.split("\\s*;\\s*");
        SchoolTextBook sTB = new SchoolTextBook(ProducerConverter(current[0]),
                current[6],Integer.parseInt(current[7]));
        sTB.setName(current[1]);
        sTB.setPrice(Double.parseDouble(current[2]));
        sTB.setAuthor(current[3]);
        sTB.setLanguage(current[4]);
        sTB.setPageCount(Integer.parseInt(current[5]));
        sTB.setAvailable(current[8].charAt(0)=='V');
        return sTB;
    }

    //1.	getAllBooks for 8graders
    public static ArrayList<SchoolTextBook> getBooksFor8thGrade(SchoolTextBook[] schoolTextBooks){
        ArrayList<SchoolTextBook> sTB = new ArrayList<>() ;
        for(SchoolTextBook s :schoolTextBooks){
            if(s.getGrade()==8)
                sTB.add(s);
        }
        return sTB;
    }
    //2.	get max price  book for Math(subject)
    public static SchoolTextBook getBMaxPricedMathBook(SchoolTextBook[] schoolTextBooks){
        ArrayList<SchoolTextBook> sTB = new ArrayList<>() ;
        for(SchoolTextBook s :schoolTextBooks){
            if(s.getSubject().equalsIgnoreCase("Mathematics"))
                sTB.add(s);
        }
        return Collections.max(sTB,new PriceComparator());
    }
    //3.	get max price item  // oobshii hamar


    //4.	get books written by Rubina Nazaryan for  Armenian Literature
    public static void PrintBooksforEnglishbyAuthor(SchoolTextBook[] schoolTextBooks,String author){
       if(author.isEmpty()){ //avelacnel
           throw new InvalidStringException(author);
       }
       boolean hmm= false;
        for(SchoolTextBook s :schoolTextBooks){
            if(s.getSubject().equalsIgnoreCase("English") && s.getAuthor().
                    equalsIgnoreCase(author))
                s.printInfo();
                hmm = true;
        }
        if(hmm){
            System.out.println("No such book");
        }
    }
    //5.	get price of the Physics book with minimum page count
    public static double getPriceOfPhysicsBookMinPageCount(SchoolTextBook[] schoolTextBooks){
        ArrayList<SchoolTextBook> sTB = new ArrayList<>() ;
        boolean hmm = false;
        for(SchoolTextBook s :schoolTextBooks){
            if(s.getSubject().equalsIgnoreCase("Physics"))
                hmm= true;
                sTB.add(s);
        }
       if(hmm) return Collections.min(sTB,new PriceComparator()).getPrice();
        System.out.println("No such book");
       return -1;
    }

}
