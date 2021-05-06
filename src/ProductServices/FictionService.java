package ProductServices;

import Comparators.AgeLimitComparator;
import Products.Books.Fiction;
import Products.Books.SchoolTextBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static ProducerService.ProducerService.ProducerConverter;

public class FictionService extends BooksService{
    public static Fiction FictionConverter(String fileText) { // es stringy uni hetevyal tesqy
        String[] current = fileText.split("\\s*;\\s*");
        // {Zangak,Abovyanssssm}
        Fiction fct = new Fiction(ProducerConverter(current[0]),
                Integer.parseInt(current[6]),
                current[7]);
        fct.setName(current[1]);
        fct.setPrice(Double.parseDouble(current[2]));
        fct.setAuthor(current[3]);
        fct.setLanguage(current[4]);
        fct.setPageCount(Integer.parseInt(current[5]));
        fct.setAvailable(current[8].charAt(0)=='V');
        return fct;
    }

    //1.	1.get  all detective genre books
    public static ArrayList<Fiction> getDetectives(Fiction[] fictionBooks) {
        ArrayList<Fiction> fc = new ArrayList<>();
        for (Fiction f : fictionBooks) {
            if (f.getGenre().equalsIgnoreCase("detective"))
                fc.add(f);
        }
        return fc;
    }

    //2.	2.print all historical books with age limit of 16+
    public static void printHistoricalWithAgeLimit(Fiction[] fictionBooks) {
        for (Fiction f : fictionBooks) {
            if (f.getGenre().equalsIgnoreCase("horror") &&
                    f.getAge_limit() >= 16)
                f.printInfo();

        }
    }

    //.	3.get all the fantasy books that were written by certain author
    public static ArrayList<Fiction> getFantasyBooksByAuthor(Fiction[] fictionBooks, String author) {
        ArrayList<Fiction> fc = new ArrayList<>();
        for (Fiction f : fictionBooks) {
            if (f.getGenre().equalsIgnoreCase("fantasy") &&
                    f.getAuthor().equalsIgnoreCase(author))
                fc.add(f);
        }
        return fc;
    }

    //4 sort by  age limit
    public static ArrayList<Fiction> sortByAgeLimit(Fiction[] fictionBooks) {
        ArrayList<Fiction> fc = new ArrayList<>(Arrays.asList(fictionBooks));
        Collections.sort(fc, new AgeLimitComparator());
        return fc;
    }

    //5  print book that was published by Zangak and has minimum agelimit
    public static void printMinAgeLimitZangakFantasyBook(Fiction[] fictionBooks) {
        ArrayList<Fiction> fc = new ArrayList<>();
        for (Fiction f : fictionBooks) {
            if (f.getGenre().equalsIgnoreCase("fantasy") &&
                    f.getMAKER().getName().equalsIgnoreCase("Zangak"))
                fc.add(f);
            Collections.min(fc, new AgeLimitComparator()).printInfo();
        }
    }

    //6. print page counts of Mangas that are 12+
    public static void printPageCountsOfMangas12plus(Fiction[] fictionBooks) {
        for (Fiction f : fictionBooks) {
            if (f.getGenre().equalsIgnoreCase("manga") &&
                    f.getAge_limit() >= 12)
                System.out.println(f.getPageCount());
        }
    }
}
