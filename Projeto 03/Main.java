import java.util.Scanner;

public class Main {

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String nickname;

        while(true) {
            clearConsole();
            System.out.print("Informe um apelido: ");
            nickname = scanner.next();
            if(!nickname.equalsIgnoreCase("")) {
                String res;
                while(true) {
                    clearConsole();
                    System.out.println("O apelido informado foi: " + nickname);
                    System.out.println("Caso queira escolher outro apelido digite (mudar) ou digite (continuar) para seguir para o jogo.");
                    res = scanner.next();
                    if(res.equalsIgnoreCase("continuar") || res.equalsIgnoreCase("mudar")) break;
                }

                if(res.equalsIgnoreCase("continuar")) break;
            }
        }

        clearConsole();
        System.out.println("Seu nome é " + nickname);
        System.out.println("Agora você já pode começar a jogar!");

        Game game = new Game(nickname);
        

        scanner.close();
    }
}