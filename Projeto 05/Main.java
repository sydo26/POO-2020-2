import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void execute(Contato contato, String name, Object ...params) {
        if(contato != null) {
            Method method;
            try {
                if(params.length == 1) {
                    method = contato.getClass().getMethod(name, int.class);
                    method.invoke(contato, params[0]);
                }else if(params.length == 2) {
                    method = contato.getClass().getMethod(name, String.class, String.class);
                    method.invoke(contato, params[0], params[1]);
                }else {
                    method = contato.getClass().getMethod(name);
                    method.invoke(contato);
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Inicie o contato primeiro!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Contato contato = null;
        boolean exit = false;
        while(!exit) {
            String command = "";
            try { command = scan.next(); } catch (NoSuchElementException e) {
                // ignore
            }
            switch(command) {
                case "$init":
                    String name;
                    try {
                        name = scan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Você não informou da forma correta o nome. Tente novamente");
                        break;
                    }
     
                    if(name.length() > 0) {
                        contato = new Contato(name);
                    }else {
                        System.out.println("Desculpe, você informou um nome vazio");
                    }
                    break;
                case "$end":
                    exit = true;
                    break;

                case "$show": execute(contato, "show"); break;

                case "$add": {
                    String label;
                    String number;
                    try {
                        label = scan.next();
                        number = scan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Você não informou da forma correta o label e o número. Tente novamente");
                        break;
                    }

                    if(label.length() > 0 && number.length() > 0) {
                        execute(contato, "addFone", label, number);
                    }else {
                        System.out.println("Desculpe, você informou um label ou número vazio");
                    }
                } break;

                case "$rm": {
                    int index;
                    try {
                        index = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Você não informou da forma correta o index. Tente novamente");
                        break;
                    }

                    if(index >= 0) {
                        execute(contato, "removeFone", index);
                    }else {
                        System.out.println("Desculpe, você informou um index inválido.");
                    }
                } break;

                default: 
                    if(!command.equals("")) {
                        System.out.printf("Comando %s inexistente!%n", command);
                    }
                    break;
                
            }
        }

        scan.close();
    }
}