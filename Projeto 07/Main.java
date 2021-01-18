import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Topic topic = new Topic();
    Scanner scan = new Scanner(System.in);

    while (true) {
      String command = scan.next();
      String arguments[] = scan.nextLine().replaceFirst(" ", "").split(" ");

      switch (command) {
        case "$init": {
          if (arguments.length >= 2) {
            try {
              int lotacao = Integer.parseInt(arguments[0]);
              int qtdPref = Integer.parseInt(arguments[1]);

              if (lotacao > qtdPref) {
                topic = new Topic(lotacao, qtdPref);
              } else {
                System.out.println("fail: não pode existir mais cadeiras preferenciais do que a lotação");
              }
            } catch (NumberFormatException e) {
              System.out.println("fail: os argumentos precisam ser inteiros");
            }
          }
          break;
        }

        case "$show": {
          topic.show();
          break;
        }
        case "$in": {
          if (arguments.length >= 1) {
            try {
              int age = arguments.length > 1 ? Integer.parseInt(arguments[1]) : -1;
              topic.subir(new Pass(arguments[0], age));
            } catch (NumberFormatException e) {
              System.out.println("fail: o segundo argumento precisa ser um inteiro");
            }
          }

          break;
        }

        case "$out": {
          if (arguments.length == 1) {
            topic.descer(arguments[0]);
          }
          break;
        }

        case "$end":
          return;

        default:
          break;
      }
    }
  }
}