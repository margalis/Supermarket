package Products.Books;

import Exceptions.InvalidStringException;
import Producer.Producer;

public abstract class TextBook extends Book{
    private String subject;
    public TextBook(Producer producer, String subject){
        super(producer);
        if(subject.isEmpty() || subject.equals(null) || subject.trim().isEmpty()){
            System.out.println("TextBooks subject");
            throw new InvalidStringException(subject);
        }
        this.subject=subject;
        BookCount++;
    }
    public abstract void Counter();

    public String getSubject() {
        return subject;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Subject:  %s, ",subject);
    }

    @Override
    public String toString() {

        return new StringBuilder().append(super.toString()).append("TextBook{").
                append("subject='").append(subject).append('\'').
                append('}').toString();
    }
}
