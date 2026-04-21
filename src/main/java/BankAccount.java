import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {

    private static final Logger logger = LogManager.getLogger(BankAccount.class);

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //DEPOSIT
    public void deposit(double amount) {
        logger.trace("Entering deposit() with amount={}", amount);

        if (amount < 0) {
            logger.warn("Invalid deposit: amount {} is negative", amount);
            return;
        }

        logger.debug("Balance before deposit: {}", balance);
        balance += amount;
        logger.info("Deposited {} successfully. New balance={}", amount, balance);
        logger.trace("Exiting deposit()");
    }

    //WITHDRAW
    public void withdraw(double amount) {
        logger.trace("Entering withdraw() with amount={}", amount);

        if (amount < 0) {
            logger.warn("Invalid withdraw: amount {} is negative", amount);
            return;
        }

        logger.debug("Balance before withdraw: {}", balance);

        if (amount > balance) {
            logger.error("Withdraw failed: insufficient balance. balance={}, requested={}", balance, amount);
            return;
        }

        balance -= amount;
        logger.info("Withdrawn {} successfully. New balance={}", amount, balance);
        logger.trace("Exiting withdraw()");
    }

    //GET BALANCE
    public double getBalance() {
        logger.trace("Entering getBalance()");
        logger.debug("Current balance={}", balance);

        if (balance < 0) {
            logger.fatal("CRITICAL: balance is negative! Possible system/config issue.");
        }

        logger.trace("Exiting getBalance()");
        return balance;
    }
}