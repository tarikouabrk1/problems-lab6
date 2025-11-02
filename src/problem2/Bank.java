package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) == null) {
            customers.add(new Customer(customerName, initialTransaction));
            System.out.println("New customer added: " + customerName);
        }
        else {
            System.out.println("Customer " + customerName + " already exists!");
        }
    }

    public void addTransaction(String customerName, double amount) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(amount);
            System.out.println("Transaction of " + amount + " added for " + customerName);
        }
        else {
            System.out.println("Customer not found: " + customerName);
        }
    }

    private Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void printStatements() {
        System.out.println("\nBank: " + name + " — Customer Statements");
        for (Customer c : customers) {
            System.out.println("\nCustomer: " + c.getName());
            System.out.println("Transactions:");
            for (Double t : c.getTransactions()) {
                double amount = t; // unboxing Double → double
                System.out.printf("  %.2f\n", amount);
            }
        }
    }

    @Override
    public String toString() {
        return "Bank{name='" + name + "', customers=" + customers + "}";
    }
}
