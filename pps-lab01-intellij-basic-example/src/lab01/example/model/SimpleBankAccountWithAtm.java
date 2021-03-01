package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    protected boolean isWithdrawAllowed(final double amount){
        return super.getBalance() + 1 >= amount;
    }

    @Override
    protected boolean isDepositAllowed(double amount) {
        return (super.getBalance() + amount) >= 1;
    }

    @Override
    protected void transactionSideEffect() {
        super.setBalance(super.getBalance() - 1);
    }
}
