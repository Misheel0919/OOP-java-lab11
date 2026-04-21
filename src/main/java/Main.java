public class Main {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount(1000);
        acc.deposit(500);
        acc.deposit(-50);
        acc.withdraw(200);
        acc.withdraw(5000);
        acc.withdraw(-30);
        acc.getBalance();

        Customer c1 = new Customer("Bold", "bold@gmail.com");
        System.out.println(c1.getDomain());

        Customer c2 = new Customer("Bat", null); // BUG scenario
        System.out.println(c2.getDomain());

        Customer c3 = new Customer("Misheel", "misheelgmail.com"); // invalid format
        System.out.println(c3.getDomain());
    }
}