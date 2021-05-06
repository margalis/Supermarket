package ProductServices;

import Comparators.PriceComparator;
import Products.Books.SchoolTextBook;
import Products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProductService {
    public static Product GetMaxPriceProduct(Product[] products) {
        ArrayList<Product> pr = new ArrayList<>(Arrays.asList(products));
        return Collections.max(pr, new PriceComparator());
    }

    public static ArrayList<Product> sortByPrice(Product[] products) {
        ArrayList<Product> pr = new ArrayList<>(Arrays.asList(products));
        Collections.sort(pr, new PriceComparator());
        return pr;
    }

    public static ArrayList<Product> MadeByCertainProducerType(Product[] products, String prodType) {
        ArrayList<Product> pr = new ArrayList<>();
        int counter = 0;
        for (Product product : products) {
            if (product.getMAKER().getType().equalsIgnoreCase(prodType)) {
                counter++;
                pr.add(product);
            }
        }
        return pr;
    }
}
