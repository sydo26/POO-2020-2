import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter(new Agency(), new Scanner(System.in));
        starter.start();
        // Agency agencia = new Agency();
        // agencia.addClient("Vini");
        // agencia.addClient("Milenna");

        // agencia.getAccount(0).deposit(100.50);
        // agencia.getAccount(0).toWithDraw(50);

        // System.out.println(agencia.accountsToString());

    }
}