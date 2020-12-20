import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void execute(Pet pet, String name) {
        if(pet != null) {
            Method method;
            try {
                method = pet.getClass().getMethod(name);
                method.invoke(pet);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Inicie o pet primeiro!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pet pet = null;
        boolean exit = false;
        while(!exit) {
            String command = "";
            try { command = scan.next(); } catch (NoSuchElementException e) {
                // ignore
            }
            switch(command) {
                case "$init":
                    int energy;
                    int hungry;
                    int clean;
                    try {
                        energy = scan.nextInt();
                        hungry = scan.nextInt();
                        clean = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Você não informou da forma correta os atributos (energy, hungry e clean). Tente novamente");
                        break;
                    }
     
                    if(energy > 0 && hungry > 0 && clean > 0) {
                        pet = new Pet(energy, hungry, clean);
                    }else {
                        System.out.println("Desculpe, você informou um valor de energia igual ou menor a 0. Tente novamente");
                    }
                    break;
                case "$end":
                    exit = true;
                    break;

                case "$show": execute(pet, "show"); break;

                case "$play": execute(pet, "play"); break;

                case "$eat": execute(pet, "eat"); break;

                case "$clean": execute(pet, "clean"); break;

                case "$sleep": execute(pet, "sleep"); break;

                default: 
                    if(command != "") {
                        System.out.println("Comando inexistente!");
                    }
                    break;
                
            }
        }

        scan.close();
    }
}