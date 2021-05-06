package Comparators;

import Products.Books.Book;
import Products.Books.Fiction;

import java.util.Comparator;

public class AgeLimitComparator implements Comparator<Fiction> {

    @Override
    public int compare(Fiction o1, Fiction o2) {
        if(o1.getAge_limit()>o2.getAge_limit()){
            return 1;
        }
        if(o1.getAge_limit()<o2.getAge_limit()){
            return -1;
        }
        return 0;
    }
}
