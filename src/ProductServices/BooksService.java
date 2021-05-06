package ProductServices;

import Comparators.PageCountComparator;
import Comparators.PriceComparator;
import Products.Books.Book;
import Products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BooksService extends ProductService {
    //just yndhanur functions
    //1.	print all books that were published by Zangak \\ esi obshi booker hamar
    public static void PrintZangakBooks(Book[] books) {
        for (Book b : books) {
            if (b.getMAKER().getName().equalsIgnoreCase("Zangak")) {
                b.printInfo();
            }
        }
    }

    //2.	order by  page count
    public static void orderByPageCount(Book[] books) {
        ArrayList<Book> pr = new ArrayList<>(Arrays.asList(books));
        Collections.sort(pr, new PageCountComparator());
        for (Book b : pr)
            {
                System.out.println(b.getName() + " " + b.getPageCount());
            }
        }

        //3.	print the ones that are written in English \\ obshii hamar
        public static void printEnglishs (Book[] books){
            for (Book b : books) {
                if (b.getLanguage().equalsIgnoreCase("English")) {
                    b.printInfo();
                }
            }

        }
        //4.	print names of books of certain author (i.e.)
        public static void PrintNamesOfAuthorsBooks (Book[] books, String Author){
            boolean bo = false;
            for (Book b : books) {
                if (b.getAuthor().equalsIgnoreCase(Author)) {
                    System.out.println(b.getName());
                    bo = true;
                }
            }
            System.out.println(!bo ? "\nNO books found" : " ");
        }

    }
