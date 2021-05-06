package Exceptions;

public class WrongComputerType extends RuntimeException{
    public WrongComputerType(String s){
        super("Wrong type:"+ s + " :must be either Desktop or Notebook or eBook_Reader");
    }
}
