package Exceptions;

public class NegativeValueException extends RuntimeException{
    public NegativeValueException(int eger){
        super("is negative: " + eger);
    }
    public NegativeValueException(double val){
        super("is negative: " + val);
    }
}
