import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSimpleBankAccountTest {

    protected final int WRONG_USR_ID = 2;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    protected AccountHolder getAccountHolder() {
        return accountHolder;
    }

    protected BankAccount getBankAccount() {
        return bankAccount;
    }

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = specificBankAccount();
    }

    protected abstract BankAccount specificBankAccount();

    @Test
    void testAccountHolder() {
        assertEquals(accountHolder, bankAccount.getHolder());
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.getBankAccount().deposit(this.getAccountHolder().getId(), 100);
        assertEquals(100, getBankAccount().getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.getBankAccount().deposit(this.getAccountHolder().getId(), 100);
        this.getBankAccount().deposit(WRONG_USR_ID, 50);
        assertEquals(100, getBankAccount().getBalance());
    }

    @Test
    void testWithdraw() {
        this.getBankAccount().deposit(this.getAccountHolder().getId(), 100);
        this.getBankAccount().withdraw(this.getAccountHolder().getId(), 70);
        assertEquals(30, getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.getBankAccount().deposit(this.getAccountHolder().getId(), 100);
        this.getBankAccount().withdraw(WRONG_USR_ID, 70);
        assertEquals(100, getBankAccount().getBalance());
    }
}
