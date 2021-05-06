package Products.Technology;

import Producer.Producer;
import Products.Product;

public abstract class Technology extends Product {
    public static int TechCount;

    protected Technology(Producer producer) {
        super(producer);
    }
}
