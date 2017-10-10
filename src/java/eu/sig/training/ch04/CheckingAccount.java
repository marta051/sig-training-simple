package eu.sig.training.ch04;

public class CheckingAccount extends Account {

    private int transferLimit = 100;

    @Override
    public Transfer makeTransfer(String counterAccount, Money amount) throws BusinessException {
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
        return super.makeTransfer(counterAccount, amount);
    }

}