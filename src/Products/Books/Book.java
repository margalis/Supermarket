package Products.Books;

import Exceptions.InvalidStringException;
import Exceptions.NegativeValueException;
import Producer.Producer;
import Products.Product;

public abstract class Book extends Product {
    //es depqum producer y darnum a publishery
    private String Author; // togh meky lini
    private String Language;
    private int PageCount;
    public static int BookCount;

    protected Book(Producer producer) {
        super(producer);
    }
    public abstract void Counter();

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        if(author.isEmpty() || author.equals(null) || author.trim().isEmpty())
        throw new InvalidStringException(author);
        else Author = author;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        if(language.isEmpty() || language.equals(null) || language.trim().isEmpty())
            throw new InvalidStringException(language);
        else Language = language;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        if(pageCount<0){
            throw new NegativeValueException(pageCount);
        }
        PageCount = pageCount;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Author:  %s, ",Author);
        System.out.printf("Language: %s, ", Language);
        System.out.printf("Page Count: %d, ", PageCount);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Book{").
                append("Author='").append(Author).append('\'').
                append(", Language='").append(Language).
                append('\'').append(", PageCount=").
                append(PageCount).append('}').toString();
    }
}
