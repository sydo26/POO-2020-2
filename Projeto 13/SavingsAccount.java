public class SavingsAccount extends Account {

    public SavingsAccount(int id, String clientId) {
        super(id, clientId);
        this.type = AccountType.CP;
    }

    @Override
    protected void monthlyUpdate() {
        this.balance += this.balance * 0.01;
    }

}
