import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Agenda agenda = new Agenda();
        boolean exit = false;
        while (!exit) {
            String command = "";
            try {
                command = scan.next();
            } catch (NoSuchElementException e) {
                // ignore
            }

            switch (command) {
                case "$end":
                    exit = true;
                    break;

                case "$show":
                    agenda.show(agenda.getContatos());
                    break;

                case "$add": {
                    String name = scan.next();
                    List<Fone> fones = new ArrayList<>();
                    String[] line = scan.nextLine().trim().split(" ");
                    for (String value : line) {
                        String label = value.split(":")[0];
                        String number = value.split(":")[1];
                        fones.add(new Fone(label, number));
                    }
                    agenda.addContato(name, fones);
                    break;
                }

                case "$search": {
                    String pattern = scan.next();
                    agenda.show(agenda.search(pattern));
                    break;
                }

                case "$rm": {
                    String name = scan.next();
                    if (!name.isEmpty())
                        agenda.rmContato(name);
                    break;
                }

                case "$rmFone": {
                    String name = scan.next();
                    int id = scan.nextInt();
                    if (!name.isEmpty())
                        agenda.rmFone(name, id);
                    break;
                }

                default:
                    if (!command.equals("")) {
                        System.out.printf("Comando %s inexistente!%n", command);
                    }
                    break;

            }
        }

        scan.close();
    }
}