import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSimpleBankAccountTest {

    private AccountHolder accountHolder;

    private BankAccount bankAccount;

    public AccountHolder getAccountHolder() {
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
        this.getBankAccount().deposit(2, 50);
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
        this.getBankAccount().withdraw(2, 70);
        assertEquals(100, getBankAccount().getBalance());
    }
}
