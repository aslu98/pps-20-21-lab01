package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void depositWithAtm(final int usrID, final double amount) {
        if (isTransactionWithAtmAllowed(amount)){
            if (super.deposit(usrID, amount)){
                this.transactionSideEffect();
            }
        }
    }

    public void withdrawWithAtm(final int usrID, final double amount) {
        if (isTransactionWithAtmAllowed(amount)){
           if (super.withdraw(usrID, amount)){
               this.transactionSideEffect();
           }
        }
    }

    private boolean isTransactionWithAtmAllowed(final double amount){
        return (super.getBalance() + amount) >= 1;
    }

    protected void transactionSideEffect(){
        super.setBalance(super.getBalance() - 1);
    }
}
