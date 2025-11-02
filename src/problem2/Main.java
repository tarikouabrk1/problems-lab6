package problem2;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        bank.addCustomer("Alice", 100.0);
        bank.addCustomer("Bob", 50.0);
        bank.addTransaction("Alice", -20.0); // debit
        bank.addTransaction("Alice", 200.0); // credit
        bank.addTransaction("Bob", -10.0);
        bank.addTransaction("Bob",300);
        bank.printStatements();
    }
}
