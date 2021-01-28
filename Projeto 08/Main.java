import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter(new Agenda(), new Scanner(System.in));
        starter.start();
    }
}