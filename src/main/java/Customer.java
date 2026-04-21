import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer {
    private static final Logger logger = LogManager.getLogger(Customer.class);

    private String name;
    private String email;

    public Customer(String name, String email) {
        logger.trace("Entering Customer constructor");

        this.name = name;
        this.email = email;

        logger.info("Customer created: name={}, email={}",
                name,
                mask(email));

        if (email == null) {
            logger.warn("Customer created with NULL email for name={}", name);
        }

        logger.trace("Exiting Customer constructor");
    }

    public String getDomain() {
        logger.trace("Entering getDomain()");
        logger.debug("getDomain called with email={}", mask(email));

        if (email == null) {
            logger.error("Cannot extract domain: email is NULL");
            return "INVALID_EMAIL";
        }

        if (!email.contains("@")) {
            logger.error("Invalid email format (missing @): {}", mask(email));
            return "INVALID_EMAIL";
        }

        String domain = email.substring(email.indexOf("@") + 1).toUpperCase();
        logger.info("Extracted domain successfully: {}", domain);
        logger.trace("Exiting getDomain()");
        return domain;
    }

    public String getName() {
        logger.debug("getName called for user={}", name);
        return name;
    }

    //Security: masking
    private static String mask(String s) {
        if (s == null || s.length() < 4) return "***";
        return s.substring(0, 2) + "***" + s.substring(s.length() - 2);
    }
}