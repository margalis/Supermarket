package Market;

import Employees.Employee;
import Products.Product;

import java.util.ArrayList;


public interface IMarketFunctionality  {
    public boolean AreThereProducts();

    public boolean AreThereEmployees();

    public ArrayList<Product> sortProductsByPrice();

    public ArrayList<Employee> getAvailableEmployees();

    public ArrayList<Product> getAvailableProducts();

    public void printProducts();

    public void printEmployeeNamesAndTasks();



}
