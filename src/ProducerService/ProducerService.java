package ProducerService;

import Producer.Producer;

import java.util.Scanner;

public class ProducerService {
    public static Producer createProducer(){
        Scanner s = new Scanner(System.in);
        System.out.println("Write with '_' ");
        System.out.println("Enter Producers Name");
        String name =s.next();

        System.out.println("Enter Producers Address");
        String address =s.next();

      //  System.out.println("Enter Producers WebSite");
      //  String website =s.next();

        System.out.println("Enter Producers Type,for example:Private Company,Small Business...");
        String type =s.next();

        Producer pr =new Producer(name,address,type);
        return pr;
    }
    public static Producer ProducerConverter(String filetext){

        String[] currenticresult = filetext.split("\\s*,\\s*");
        //name, address ,type
        Producer pr = new Producer(currenticresult[0],
                currenticresult[1], currenticresult[2]);
        return pr;
    }
}
