import java.util.Scanner;

import models.Enemy;
import models.Player;

public class Main {
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
    }

    public static void main(String[] args) {
        Player player = null;
        Enemy enemy = null;

        Scanner scanner = new Scanner(System.in);
        while(true) {
            clearConsole();
            System.out.print("Escolha o nome de seu personagem: ");
            String name = scanner.nextLine();
            if(name != "") {
                player = new Player(name);
                break;
            }
        }

        enemy = new Enemy("MONSTRO");
        String input;
        while(true) {
            clearConsole();
            System.out.println(player);
            System.out.println(enemy);
            System.out.println("");
            System.out.println("Você avistou um monstro, deseja atacar? (S/N)");
            input = scanner.next();
            if(input.equalsIgnoreCase("s") || input.equalsIgnoreCase("n")) break;
        }

        if(input.equalsIgnoreCase("s")) {
            clearConsole();
            System.out.println("O ataque está prestes a começar!\n");
            player.startAttack(enemy);
            enemy.startAttack(player);
        }else {
            System.out.println("Você desviou do monstro e conseguiu escapar com sucesso! Agora fuja e não olhe para trás!");
        }
    }
}