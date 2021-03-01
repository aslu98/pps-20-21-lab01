import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractSimpleBankAccountTest {

    @BeforeEach
    void beforeEach(){
        super.setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        super.setBankAccount(new SimpleBankAccount(super.getAccountHolder(), 0));
    }

    @Test
    void testDeposit() {
        deposit();
        assertEquals(100, getBankAccount().getBalance());
    }

    @Test
    void testWrongDeposit() {
        wrongDeposit();
        assertEquals(100, getBankAccount().getBalance());
    }

    @Test
    void testWithdraw() {
        withdraw();
        assertEquals(30, getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdraw() {
        wrongWithdraw();
        assertEquals(100, getBankAccount().getBalance());
    }
}
