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
    public boolean deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    private boolean isWithdrawAllowed(final double amount){
        return balance >= amount;
    }
}
