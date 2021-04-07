import java.util.NoSuchElementException;
import java.util.Scanner;

public class Starter {
  public static final String PREFIX = "$";
  protected Scanner scanner;
  protected Services services;
  private boolean exit;
  private String command;

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Starter(Services services, Scanner scanner) {
    this.scanner = scanner;
    this.services = services;
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
      System.exit(0);
      break;
    case "adduser":
      addUser();
      break;
    case "allusers":
      allUsers();
      break;
    case "newchat":
      newChat();
      break;
    case "chats":
      showChats();
      break;
    case "invite":
      invite();
      break;
    case "users":
      showUsers();
      break;
    case "leave":
      leave();
      break;
    case "zap":
      sendMessage();
      break;
    case "ler":
      read();
      break;
    case "notify":
      readNotify();
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

  public void addUser() throws ExceptionControl {
    String name;
    try {
      name = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    int result = this.services.createUser(name);

    // 1 = criou o usuário
    // 0 = Usuário já existe

    if (result == 0) {
      throw new ExceptionControl("usuário já existe");
    }
  }

  public void allUsers() {
    System.out.println(this.services.toStringAllUsers());
  }

  public void newChat() throws ExceptionControl {
    String name;
    String chat;
    try {
      name = this.scanner.next();
      chat = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    int result = this.services.createChat(name, chat);

    if (result == 0) {
      throw new ExceptionControl("o usuário não existe");
    }

    if (result == -1) {
      throw new ExceptionControl("o chat já existe");
    }
  }

  public void showChats() {
    String name = this.scanner.next();
    this.scanner.nextLine();

    System.out.println(this.services.toStringAllChatsUser(name));
  }

  public void invite() throws ExceptionControl {
    String guess;
    String invited;
    String chat;
    try {
      guess = this.scanner.next();
      invited = this.scanner.next();
      chat = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    int result = this.services.invite(guess, invited, chat);

    if (result == 0) {
      throw new ExceptionControl("o primeiro usuário não existe");
    }

    if (result == -1) {
      throw new ExceptionControl("o segundo usuário não existe");
    }

    if (result == -2) {
      throw new ExceptionControl("o chat não existe");
    }

    if (result == -3) {
      throw new ExceptionControl("o usuário não está no chat");
    }
  }

  public void showUsers() throws ExceptionControl {
    String chat;
    try {
      chat = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    System.out.println(this.services.toStringAllUsersChat(chat));
  }

  public void leave() throws ExceptionControl {

    String name;
    String chat;
    try {
      name = this.scanner.next();
      chat = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    int result = this.services.leave(name, chat);

    if (result == 0) {
      throw new ExceptionControl("o usuário não existe");
    }

    if (result == -1) {
      throw new ExceptionControl("o chat não existe");
    }
  }

  public void sendMessage() throws ExceptionControl {
    String name;
    String chat;
    String message;
    try {
      name = this.scanner.next();
      chat = this.scanner.next();
      message = this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    int result = this.services.sendMessage(name, chat, message);

    if (result == 0) {
      throw new ExceptionControl("o usuário não existe");
    }

    if (result == -1) {
      throw new ExceptionControl("O chat não existe");
    }
  }

  public void read() throws ExceptionControl {
    String name;
    String chat;
    try {
      name = this.scanner.next();
      chat = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    String result = this.services.read(name, chat);

    // null ou '' ou message
    if (result == null) {
      throw new ExceptionControl("o usuário não existe");
    }

    if (result.isEmpty()) {
      throw new ExceptionControl("O chat não existe");
    }

    if (result.equals("!@!@$!@$")) {
      throw new ExceptionControl("O usuário não está no chat");
    }

    System.out.println(result);
  }

  public void readNotify() throws ExceptionControl {
    String name;
    try {
      name = this.scanner.next();
      this.scanner.nextLine();
    } catch (Exception e) {
      throw new ExceptionControl("os dados estão em um formato incorreto");
    }

    String result = this.services.readNotify(name);

    if (result == null) {
      throw new ExceptionControl("o usuário não existe");
    }

    System.out.println(result);
  }
}
