public class CurrentAccount extends Account {

    public CurrentAccount(int id, String clientId) {
        super(id, clientId);
        this.type = AccountType.CC;
    }

    @Override
    protected void monthlyUpdate() {
        this.balance -= 20;
    }

}
