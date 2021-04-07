import java.util.Map;
import java.util.TreeMap;

public class Agency {

    protected Map<String, Client> clients;
    protected Map<Integer, Account> accounts;
    private int countId;

    public Agency() {
        this.clients = new TreeMap<>();
        this.accounts = new TreeMap<>();
        this.countId = 0;
    }

    public void update() {
        for (Account ac : this.accounts.values()) {
            ac.monthlyUpdate();
        }
    }

    public Client getClient(String id) {
        if (!clients.containsKey(id))
            return null;
        return clients.get(id);
    }

    public Account getAccount(int id) {
        if (!accounts.containsKey(id))
            return null;
        return accounts.get(id);
    }

    public void addClient(String id) {
        clients.computeIfAbsent(id, k -> {
            Client client = new Client(id);
            CurrentAccount cc = new CurrentAccount(this.countId++, client.id);
            SavingsAccount cp = new SavingsAccount(this.countId++, client.id);

            this.accounts.put(cc.id, cc);
            this.accounts.put(cp.id, cp);

            client.addAccount(cc.id, cc);
            client.addAccount(cp.id, cp);
            return client;
        });
    }

    public String accountsToString() {
        StringBuilder builder = new StringBuilder();

        for (Account account : accounts.values()) {
            builder.append(account.toString()).append('\n');
        }

        return builder.toString();

    }

}
