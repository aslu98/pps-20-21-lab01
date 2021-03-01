package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdraw is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractSimpleBankAccount {

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    protected boolean isWithdrawAllowed(final double amount){
        return super.getBalance() >= amount;
    }

    @Override
    protected boolean isDepositAllowed(double amount) {
        return true;
    }

    @Override
    protected void transactionSideEffect() {
    }
}
