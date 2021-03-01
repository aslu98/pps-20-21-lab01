package lab01.example.model;

public abstract class AbstractSimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    public AbstractSimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID) && isDepositAllowed(amount)) {
            this.balance += amount;
            transactionSideEffect();
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            transactionSideEffect();
        }
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    protected abstract boolean isWithdrawAllowed(final double amount);

    protected abstract boolean isDepositAllowed(final double amount);

    protected abstract void transactionSideEffect();

}
