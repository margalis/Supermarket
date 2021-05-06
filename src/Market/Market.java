package Market;

import Comparators.PriceComparator;
import Employees.Assistant;
import Employees.Employee;
import Exceptions.InvalidStringException;
import Products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Market implements IMarketFunctionality { // implements IMarketFunctionality

    private Product[] products;
    private int product_quantity;
    private Employee[] employees;
    private int employee_quantity;
    private String Address;
    private String Name;

    public Market(Product[] products, int product_quantity, Employee[] employees,
                  int employee_quantity, String name, String address) {
        this.products = products;
        this.product_quantity = product_quantity;
        this.employees = employees;
        this.employee_quantity = employee_quantity;

        this.Name = name;
        this.Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        if (address.isEmpty() || address == null || address.trim().isEmpty()) {
            throw new InvalidStringException(address);
        } else this.Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name == null || name.trim().isEmpty()) {
            throw new InvalidStringException(name);
        } else this.Name = name;

    }

    @Override
    public String toString() {
        return new StringBuilder().append("Market{").append(", product_quantity=").
                append(product_quantity).append(", employee_quantity=").append(employee_quantity).
                append(", Address='").append(Address).append('\'').append(", Name='").
                append(Name).append('\'').append('}').toString();
    }

    @Override
    public boolean AreThereProducts() {
        return !(product_quantity == 0);
    }

    @Override
    public boolean AreThereEmployees() {
        return !(employee_quantity == 0);
    }

    @Override
    public ArrayList<Product> sortProductsByPrice() { //iran mejic djvar pokhem
        ArrayList<Product> prods = new ArrayList<>(Arrays.asList(products));
        Collections.sort(prods, new PriceComparator());
        return prods;
    }

    @Override
    public ArrayList<Employee> getAvailableEmployees() {
        ArrayList<Employee> Employees = new ArrayList<>(Arrays.asList(employees));
        for (Employee e : Employees) {
            if (e.isAvailable()) {
                Employees.add(e);
            }
        }
        return Employees;
    }

    @Override
    public ArrayList<Product> getAvailableProducts() {
        ArrayList<Product> pr = new ArrayList<>();
        for (Product product : products) {
            if (product.isAvailable()) {
                pr.add(product);
            }
        }
        return pr;
    }

    @Override
    public void printProducts() {
        for (Product product : products) {
            product.printInfo();
        }
    }

    @Override
    public void printEmployeeNamesAndTasks() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
            employee.Tasks();
        }
    }
}
