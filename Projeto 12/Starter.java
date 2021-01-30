import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Starter {
  public static final String PREFIX = "$";
  protected Twitter twitter;
  protected Scanner scanner;
  private boolean exit;
  private String command;

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Starter(Twitter twitter, Scanner scanner) {
    this.twitter = twitter;
    this.scanner = scanner;
    this.exit = false;
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
      case "end":
        setExit(true);
        break;
      case "adduser":
        addUser();
        break;
      case "follow":
        follow();
        break;
      case "show":
        show();
        break;
      case "twittar":
        twittar();
        break;
      case "timeline":
        timeline();
        break;
      case "like":
        like();
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

  protected void show() {
    this.twitter.showUsers(this.twitter.getAllUsers());
  }

  protected void addUser() throws ExceptionControl {
    String username = this.scanner.next();
    if (username.isEmpty())
      throw new ExceptionControl("você deve informar um nome de usuário");
    boolean approved = this.twitter.createUser(username);
    if (!approved)
      throw new ExceptionControl("já existe um usuário cadastrado com esse username");
  }

  protected void follow() throws ExceptionControl {
    String username = this.scanner.next();
    if (username.isEmpty())
      throw new ExceptionControl("você deve informar um nome de usuário");
    String target = this.scanner.next();
    if (target.isEmpty())
      throw new ExceptionControl("você deve informar o nome do usuário a ser seguido");
    int status = this.twitter.followUser(username, target);

    if (status == 1)
      throw new ExceptionControl("usuário [" + username + "] não encontrado");
    else if (status == 0)
      throw new ExceptionControl("usuário [" + target + "] não encontrado");
    else if (status == -1)
      throw new ExceptionControl("você já segue o usuário [" + target + "]");
  }

  protected void twittar() throws ExceptionControl {
    String username = this.scanner.next();
    if (username.isEmpty())
      throw new ExceptionControl("você deve informar um nome de usuário");
    String message = this.scanner.nextLine();
    if (message.isEmpty())
      throw new ExceptionControl("você deve informar uma mensagem para o tweet");

    boolean approved = this.twitter.twittar(username, message.trim());
    if (!approved)
      throw new ExceptionControl("o usuário [" + username + "] não existe");
  }

  protected void timeline() throws ExceptionControl {
    String username = this.scanner.next();
    if (username.isEmpty())
      throw new ExceptionControl("você deve informar um nome de usuário");

    boolean approved = this.twitter.timeline(username);
    if (!approved)
      throw new ExceptionControl("o usuário [" + username + "] não existe");
  }

  protected void like() throws ExceptionControl {
    String username = this.scanner.next();
    if (username.isEmpty())
      throw new ExceptionControl("você deve informar um nome de usuário");

    int id;
    try {
      id = this.scanner.nextInt();
    } catch (InputMismatchException e) {
      throw new ExceptionControl("você deve passar um valor inteiro para o id do tweet");
    }

    if (id < 0)
      throw new ExceptionControl("Você deve informar um id acima ou igual a 0");

    // username = sara
    // id = 1
    int status = this.twitter.like(username, id);
    if (status == 1)
      throw new ExceptionControl("você já curtiu esse tweet");
    else if (status == 0)
      throw new ExceptionControl("o usuário [" + username + "] não existe");
    else if (status == -1) {
      throw new ExceptionControl("o tweet de id [" + id + "] não existe");
    }

  }
}
