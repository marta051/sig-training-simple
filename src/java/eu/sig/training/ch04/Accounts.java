package eu.sig.training.ch04;

public class Accounts {

    public Transfer makeTransfer(String counterAccount, Money amount) throws BusinessException {
        int sum = 0;
        for (int i = 0; i < counterAccount.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(counterAccount.charAt(i));
        }
        if (sum % 11 == 0) {
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount);
            return result;
        } else {
            throw new BusinessException("Invalid account number!");
        }
    }
}
