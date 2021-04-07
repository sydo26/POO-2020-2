import java.text.DecimalFormat;

public abstract class Account {
    protected int id;
    protected double balance;
    protected String clientId;
    protected AccountType type;

    protected Account(int id, String clientId) {
        this.id = id;
        this.balance = 0;
        this.clientId = clientId;
    }

    public int getID() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getClientID() {
        return clientId;
    }

    public AccountType getType() {
        return type;
    }

    protected abstract void monthlyUpdate();

    protected int toWithDraw(double value) {
        if (value <= 0)
            return 0;

        if (balance >= value) {
            this.balance -= value;
        } else {
            return -1;
        }

        return 1;
    }

    protected boolean deposit(double value) {
        if (value <= 0)
            return false;
        this.balance += value;
        return true;
    }

    protected int transfer(Account target, double value) {
        if (target == null) {
            return -1;
        }

        if (value <= 0)
            return 0;
        if (balance >= value) {
            target.balance += value;
            this.balance -= value;
        }

        return 1;
    }

    @Override
    public String toString() {
        return (new StringBuilder()).append(id).append(":").append(clientId)
                .append(String.format(":%s:", new DecimalFormat("#.##").format(balance)).replace(",", "."))
                .append(type.getValue()).toString();
    }

}
