package Products.Technology;

import Exceptions.NumberOutOfBounds;
import Exceptions.WrongComputerType;
import Products.Product;
import Producer.Producer;

public class Computer extends MobileAndPC{
    private String type;  // NoteBook or Desktop or eBook
    private int numberOfCores;
    //other properties can also be here
    public Computer(Producer producer,String type, int numberOfCores) {
        super(producer);
        if(type.isEmpty() && !type.equalsIgnoreCase("Desktop" )&&
                !type.equalsIgnoreCase("eBook_reader")
                && !type.equalsIgnoreCase("NoteBook") ){
            throw new WrongComputerType(type);
        }
        if(numberOfCores<2 || numberOfCores > 8){
         throw new NumberOutOfBounds(numberOfCores);
        }
        this.type = type;
        this.numberOfCores = numberOfCores;

        Counter();
        TechCount++;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("type:  %s, ",type);
        System.out.printf("number of cores : %d", numberOfCores);
    }

    @Override
    public void Counter() {
    countOfProductsGenerated++;
    }
}
