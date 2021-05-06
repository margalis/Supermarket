package Producer;

import Exceptions.InvalidStringException;

public class Producer {
    private String Name ; // IKEA
    private String Address; // Country ,Region ,Street
    // private String WebSite; // www.ikea.com // es stringi vra kareli a
    // url in bnorosh sahmanapakumner dnel
    private String type ; // private, small business ,company

    public Producer(String name, String address, String type) {
        if(name.isEmpty())
            throw  new InvalidStringException(name);
        if(address.isEmpty()){
            throw  new InvalidStringException(address);
        }
        /*if(webSite.isEmpty()){
            throw  new InvalidStringException(webSite);
        }*/
        if(type.isEmpty()){
            throw  new InvalidStringException(type);
        }
        else {
            this.Name = name;
            this.Address = address;
          //  this.WebSite = webSite;
            this.type = type;
        }
    }

    public void ProducerInfoPrint(){
        System.out.printf("Producer Name: %s, ",getName());
        System.out.printf("Producer Address: %s,", getAddress());
     //   System.out.printf("Producer WebSite: %s,",getWebSite());
        System.out.printf("Producer Type: %s,",getType());
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
       if(!name.isEmpty())
        Name = name;
       else {
           System.out.println("Producer name");
           throw new InvalidStringException(name);
       }

    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        if(!address.isEmpty())
        Address = address;
        else {
            System.out.println("Producer address");
            throw new InvalidStringException(address);
        }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
       if(!type.isEmpty())
        this.type = type;
       else {
            System.out.println("Producer type");
            throw new InvalidStringException(type);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Producer{").append("Name='").
                append(Name).append('\'').append(", Address='").append(Address).
                append('\'').append(", type='").append(type).
                append('\'').append('}').toString();
    }
}
