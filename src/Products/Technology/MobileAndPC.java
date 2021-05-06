package Products.Technology;

import Producer.Producer;

public abstract class MobileAndPC extends Technology{
   private int RAM;
   private int DISK_Memory;
   private String model;
   private  String OS;
   private int prddYear;


    protected MobileAndPC(Producer producer) { // Manufacturer
        super(producer);
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getDISK_Memory() {
        return DISK_Memory;
    }

    public void setDISK_Memory(int DISK_Memory) {
        this.DISK_Memory = DISK_Memory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getPrddYear() {
        return prddYear;
    }

    public void setPrddYear(int prddYear) {
        this.prddYear = prddYear;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("MobileAndPC{").append("RAM=").
                append(RAM).append(", DISK_Memory=").append(DISK_Memory).
                append(", model='").append(model).append('\'').append(", OS='").
                append(OS).append('\'').append(", prddYear=").append(prddYear).
                append('}').toString();
    }
}
