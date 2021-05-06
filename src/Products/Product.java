package Products;

import Exceptions.InvalidStringException;
import Exceptions.NegativeValueException;
import Producer.Producer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public abstract class Product {
    private String name;
    private double price;
    private boolean isAvailable;
    // private Date expirationDate; // esi foodi hamar kavelacnem
    public static int countOfProductsGenerated;
    private final Producer MAKER;


    protected Product(Producer producer)
    {   if(Objects.isNull(producer)){
        throw  new NullPointerException();
        }
        this.MAKER = producer;
    }

    public abstract void Counter(); // do I need this ? :/

    public void printInfo() {
        MAKER.ProducerInfoPrint();
        System.out.println();
        System.out.printf("Product Name: %s, ", name);
        System.out.printf("Product Price: %.1f ,", price);
        System.out.println(isAvailable ? "is Available" : "currently not available :");
      //  System.out.printf("Expiration Date: %s,", ParseExpDate(getExpirationDate()));

    }

    public Producer getMAKER() {
        return MAKER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name==null || name.trim().isEmpty()) {
            throw new InvalidStringException(name);
        } else this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else {
            System.out.println("Price");
            throw new NegativeValueException(price);
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    /*
    public Date getExpirationDate() {
        return expirationDate;
    }
    public String ParseExpDate(Date date){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date) ;
    }
    public void setExpirationDate(String expirationDate) throws ParseException {
        String pattern=  "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(expirationDate);
        this.expirationDate = date;
    }


 */

    @Override
    public String toString() {
        return new StringBuilder().
                append("Product{").append("name='").append(name).append('\'').
                append(", price=").append(price).append(", isAvailable=").
                append(isAvailable).append(", MAKER=").append(MAKER).append('}').toString();
    }
}