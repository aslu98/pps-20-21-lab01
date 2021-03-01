import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest{

    private SimpleBankAccountWithAtm bankAccountWithAtm;

    protected BankAccount specificBankAccount(){
        return new SimpleBankAccountWithAtm(super.getAccountHolder(), 0);
    }

    @BeforeEach
    void beforeEach(){
       super.beforeEach();
       this.bankAccountWithAtm = (SimpleBankAccountWithAtm) super.getBankAccount();
    }

    @Test
    void testDepositWithAtm() {
        bankAccountWithAtm.depositWithAtm(super.getAccountHolder().getId(), 100);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccountWithAtm.depositWithAtm(super.getAccountHolder().getId(), 100);
        bankAccountWithAtm.depositWithAtm(2, 50);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccountWithAtm.depositWithAtm(super.getAccountHolder().getId(), 100);
        assertEquals(99, getBankAccount().getBalance());
        bankAccountWithAtm.withdrawWithAtm(super.getAccountHolder().getId(), 70);
        assertEquals(28, getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccountWithAtm.depositWithAtm(super.getAccountHolder().getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(2, 70);
        assertEquals(99, getBankAccount().getBalance());
    }
}
