package Exceptions;

public class NumberOutOfBounds extends RuntimeException{
    public NumberOutOfBounds(int a){
        super("out of bounds:"+ a);
    }
}
