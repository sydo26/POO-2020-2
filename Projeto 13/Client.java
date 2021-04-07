import java.util.Map;
import java.util.TreeMap;

public class Client {
    protected String id;
    protected Map<Integer, Account> accounts;

    public Client(String id) {
        this.id = id;
        this.accounts = new TreeMap<>();
    }

    public void addAccount(int id, Account account) {
        this.accounts.put(id, account);
    }

    public Account getAccount(int id) {
        return accounts.get(id);
    }
}
