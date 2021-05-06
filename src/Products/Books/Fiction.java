package Products.Books;

import Exceptions.InvalidStringException;
import Exceptions.NegativeValueException;
import Producer.Producer;

public class Fiction extends Book{
    private int Age_limit;
    private String Genre;  // sa evs kara darna hierarchy yst genre-i

    public Fiction (Producer producer,int age_limit,String genre) {
        super(producer);
        if(age_limit<0){
            throw new NegativeValueException(age_limit);
        }
        if(genre.isEmpty() || genre.equals(null) || genre.trim().isEmpty()){
            throw new InvalidStringException(genre);
        }
        this.Age_limit = age_limit;
        this.Genre = genre;
        Counter();
        BookCount++;
    }

    public int getAge_limit() {
        return Age_limit;
    }

    public String getGenre() {
        return Genre;
    }

    @Override
    public void Counter(){ countOfProductsGenerated++;}

    @Override
    public void printInfo() {
        System.out.println("Fiction Book");
        super.printInfo();
        System.out.printf("Age Limit:  %d +, ",Age_limit);
        System.out.printf("Genre: %s.", Genre);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Fiction{").
                append("Age_limit=").append(Age_limit).append(", Genre='").
                append(Genre).append('\'').append('}').toString();
    }
}
