import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Starter {
  public static final String PREFIX = "$";
  protected Scanner scanner;
  protected Agency agency;
  private boolean exit;
  private String command;

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Starter(Agency agency, Scanner scanner) {
    this.scanner = scanner;
    this.exit = false;
    this.agency = agency;
  }

  public void setExit(boolean exit) {
    this.exit = exit;
  }

  public boolean isExit() {
    return exit;
  }

  public void executeCases() throws ExceptionControl {
    String cmd = getCommand().replace(PREFIX, "").toLowerCase();
    switch (cmd) {
    case "show":
      show();
      break;
    case "addcli":
      addCli();
      break;
    case "deposito":
      deposit();
      break;
    case "saque":
      withdraw();
      break;
    case "transf":
      transfer();
      break;
    case "update":
      update();
      break;
    case "end":
      System.exit(0);
      break;
    default:
      throw new ExceptionControl("comando [" + cmd + "] inexistente!");
    }
  }

  public void start() {
    while (!isExit()) {
      setCommand("");
      try {
        String v = this.scanner.next();
        if (v.startsWith(PREFIX))
          setCommand(v);
      } catch (NoSuchElementException e) {
        // ignore
      }

      if (!getCommand().isEmpty()) {
        try {
          executeCases();
        } catch (ExceptionControl e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void show() {
    System.out.println(this.agency.accountsToString());
  }

  public void addCli() {
    String name = this.scanner.nextLine();
    this.agency.addClient(name);
  }

  public void deposit() throws ExceptionControl {
    int account;
    double value;
    try {
      account = this.scanner.nextInt();
      value = this.scanner.nextDouble();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("falha ao ler os dados");
    }

    Account ac = this.agency.getAccount(account);
    if (ac == null) {
      throw new ExceptionControl("conta não existe");
    }
    boolean result = ac.deposit(value);

    if (!result) {
      throw new ExceptionControl("saldo insuficiente");
    }
  }

  public void withdraw() throws ExceptionControl {

    int account;
    double value;
    try {
      account = this.scanner.nextInt();
      value = this.scanner.nextDouble();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("falha ao ler os dados");
    }

    Account ac = this.agency.getAccount(account);
    if (ac == null) {
      throw new ExceptionControl("conta não encontrada");
    }

    int result = ac.toWithDraw(value);

    if (result == -1) {
      throw new ExceptionControl("saldo insuficiente");
    }

    if (result == 0) {
      throw new ExceptionControl("o valor sacado deve ser maior ou igual a 1");
    }
  }

  public void transfer() throws ExceptionControl {
    int accountOne;
    int accountTwo;
    double value;

    try {
      accountOne = this.scanner.nextInt();
      accountTwo = this.scanner.nextInt();
      value = this.scanner.nextDouble();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("falha ao ler os dados");
    }

    Account ac1 = this.agency.getAccount(accountOne);
    if (ac1 == null) {
      throw new ExceptionControl("a primeira conta informada não existe");
    }

    Account ac2 = this.agency.getAccount(accountTwo);

    if (ac2 == null) {
      throw new ExceptionControl("a segunda conta informada não existe");
    }

    int result = ac1.transfer(ac2, value);

    if (result == 0) {
      throw new ExceptionControl("o valor transferido deve ser maior ou igual a 1");
    }
  }

  public void update() {
    this.agency.update();
  }

}
