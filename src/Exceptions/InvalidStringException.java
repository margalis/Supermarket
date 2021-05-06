package Exceptions;

public class InvalidStringException extends RuntimeException{
    // means string is either empty or null or blank space
    public InvalidStringException(String name){
        super("is empty:" + name) ;
    }
}
