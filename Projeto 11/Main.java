import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter(new AgendaPlus(), new Scanner(System.in));
        starter.start();
    }
}