package Exceptions;

public class WrongEmployeeWorkHoursException extends RuntimeException{
    public WrongEmployeeWorkHoursException(char a){
        super("invalid work hours type.Should be either P, or F, or Q");// parttime, fulltime,quartertime
    }
}
