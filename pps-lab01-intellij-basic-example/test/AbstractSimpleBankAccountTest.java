import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSimpleBankAccountTest {

    private AccountHolder accountHolder;

    private BankAccount bankAccount;

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    protected BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    protected void deposit(){
        bankAccount.deposit(accountHolder.getId(), 100);
    }

    protected void wrongDeposit(){
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
    }

    protected void withdraw(){
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
    }

    protected void wrongWithdraw(){
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
    }

    @Test
    void testAccountHolder() {
        assertEquals(accountHolder, bankAccount.getHolder());
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }
}
