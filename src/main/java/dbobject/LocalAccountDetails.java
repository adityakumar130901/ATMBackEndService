package dbobject;

import com.turvo.teller.atm.domain.Account;

import java.math.BigDecimal;
import java.util.HashMap;

public class LocalAccountDetails {

    private static HashMap<Integer, Account> ACCOUNT_HASH_MAP;

    public static HashMap<Integer, Account> getInstance() {
        if (ACCOUNT_HASH_MAP == null) {
            ACCOUNT_HASH_MAP = new HashMap<>();
            initializeAccount();
        }
        return ACCOUNT_HASH_MAP;
    }

    private static void initializeAccount() {
        final Account account1 = new Account(1, new BigDecimal(500), 123);
        final Account account2 = new Account(2, new BigDecimal(1200), 123);
        final Account account3 = new Account(3, new BigDecimal(30000), 123);
        final Account account4 = new Account(4, new BigDecimal(12000), 123);
        final Account account5 = new Account(5, new BigDecimal(10), 123);
        final Account account6 = new Account(6, new BigDecimal(0), 123);
        ACCOUNT_HASH_MAP.put(1, account1);
        ACCOUNT_HASH_MAP.put(2, account2);
        ACCOUNT_HASH_MAP.put(3, account3);
        ACCOUNT_HASH_MAP.put(4, account4);
        ACCOUNT_HASH_MAP.put(5, account5);
        ACCOUNT_HASH_MAP.put(6, account6);


    }
}
