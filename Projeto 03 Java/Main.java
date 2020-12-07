import java.util.Scanner;

import models.Enemy;
import models.Player;

public class Main {
    public static Player player;
    public static Enemy enemy;
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
    }

    public static void main(String[] args) {
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

        System.out.println(player);
        System.out.println(enemy);
        System.out.println("");
        player.startAttack(enemy);
        enemy.startAttack(player);

    }
}