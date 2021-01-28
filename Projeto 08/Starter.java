import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Starter {
  public static final String PREFIX = "$";
  protected Agenda agenda;
  protected Scanner scanner;
  private boolean exit;
  private String command;

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Starter(Agenda agenda, Scanner scanner) {
    this.agenda = agenda;
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

      case "show":
        show();
        break;

      case "add":
        add();
        break;

      case "search":
        search();
        break;

      case "rm":
        rm();
        break;

      case "rmfone":
        rmFone();
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

  protected void search() throws ExceptionControl {
    String pattern = this.scanner.next();
    if (!pattern.isEmpty()) {
      this.scanner.nextLine();
      agenda.show(agenda.search(pattern));
    } else
      throw new ExceptionControl("não é possível executar uma busca com um valor vazio!");
  }

  protected void add() throws ExceptionControl {
    String name = this.scanner.next();

    if (name.isEmpty())
      throw new ExceptionControl("você não pode adicionar um contato sem declarar o nome do mesmo!");

    List<Fone> fones = new ArrayList<>();
    String[] lineFones = this.scanner.nextLine().trim().split(" ");
    for (String value : lineFones) {
      String[] separeted = value.split(":");
      if (separeted.length != 2)
        throw new ExceptionControl("você informou algum telefone com a formatação incorreta!");
      String label = separeted[0];
      String number = separeted[1];
      if (label.isEmpty())
        throw new ExceptionControl("o label de identificação do telefone está vazio!");
      if (Fone.isValid(number))
        fones.add(new Fone(label, number));
      else
        throw new ExceptionControl("o formato do número [" + number + "] não é permitido!");
    }

    agenda.addContato(name, fones);
  }

  protected void rm() throws ExceptionControl {
    String name = this.scanner.next();
    if (!name.isEmpty()) {
      if (!agenda.rmContato(name))
        throw new ExceptionControl("não foi possível encontrar o contato [" + name + "]");
    } else
      throw new ExceptionControl("você não pode remover um contato sem declarar o nome!");
  }

  protected void rmFone() throws ExceptionControl {
    String name = this.scanner.next();
    int id = this.scanner.nextInt();
    if (agenda.getContato(name) == null)
      throw new ExceptionControl("não foi possível encontrar o contato [" + name + "]");

    if (!name.isEmpty()) {
      if (!agenda.rmFone(name, id))
        throw new ExceptionControl("não foi possível encontrar o index [" + id + "] no contato [" + name + "]");
    } else
      throw new ExceptionControl("você não pode remove um telefone sem declarar o index!");
  }

  protected void show() {
    agenda.show(agenda.getContatos());
  }

}
