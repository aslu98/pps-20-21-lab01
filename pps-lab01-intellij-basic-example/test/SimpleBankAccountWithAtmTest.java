import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest{

    @BeforeEach
    void beforeEach(){
        super.setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        super.setBankAccount(new SimpleBankAccountWithAtm(super.getAccountHolder(), 0));
    }

    @Test
    void testDeposit() {
        deposit();
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWrongDeposit() {
        wrongDeposit();
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWithdraw() {
        withdraw();
        assertEquals(28, getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdraw() {
        wrongWithdraw();
        assertEquals(99, getBankAccount().getBalance());
    }
}
