package Comparators;

import Products.Books.Book;

import java.util.Comparator;

public class PageCountComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getPageCount()>o2.getPageCount()){
            return 1;
        }
        if(o1.getPageCount()<o2.getPageCount()){
            return -1;
        }
        return 0;
    }
}
