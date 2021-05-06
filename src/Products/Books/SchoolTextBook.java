package Products.Books;

import Exceptions.InvalidStringException;
import Exceptions.NumberOutOfBounds;
import Producer.Producer;

public class SchoolTextBook extends TextBook {
    private int Grade;
    public SchoolTextBook(Producer producer, String subject, int grade){
        super(producer,subject);
        if(grade <1 || grade>12){
            System.out.println("Grade must be inside [1,12]");
            System.out.println("but is");
            throw new NumberOutOfBounds(grade);
        }
        this.Grade= grade;
        Counter();
    }
    @Override
    public void Counter(){
        countOfProductsGenerated++;
    }

    @Override
    public void printInfo() {
        System.out.println("School TextBooks'");
        super.printInfo();
        System.out.printf("Grade:  %d. ",Grade);
    }
    public int getGrade(){
        return this.Grade;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).
                append("SchoolTextBook{").append("Grade=").
                append(Grade).append('}').toString();
    }
}
