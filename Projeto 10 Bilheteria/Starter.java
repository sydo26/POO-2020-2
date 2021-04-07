import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Starter {
  public static final String PREFIX = "$";
  protected Bilheteria bilheteria;
  protected Scanner scanner;
  private boolean exit;
  private String command;

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Starter(Bilheteria bilheteria, Scanner scanner) {
    this.bilheteria = bilheteria;
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
    case "vender":
      sell();
      break;
    case "addpessoa":
      addPeople();
      break;
    case "addevento":
      addEvent();
      break;
    case "addsetor":
      addSector();
      break;
    case "showp":
      showPeoples();
      break;
    case "showe":
      showEvents();
      break;
    case "shows":
      showSectors();
      break;
    case "showc":
      showMoney();
      break;
    case "showv":
      showSales();
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

  protected void addPeople() throws ExceptionControl {
    String name = this.scanner.next();
    if (name.isEmpty())
      throw new ExceptionControl("você deve informar um nome para a pessoa");

    int age;
    try {
      age = this.scanner.nextInt();
    } catch (InputMismatchException e) {
      throw new ExceptionControl("você deve informar um número para a idade da pessoa");
    }

    String student = this.scanner.next();
    if (age < 1)
      throw new ExceptionControl("não se pode passar uma idade inferior a 1");
    if (student.isEmpty())
      throw new ExceptionControl("você deve informar se a pessoa é ou não é um estudante");
    if (!(student.equalsIgnoreCase("sim") || student.equalsIgnoreCase("nao")))
      throw new ExceptionControl("você deve informar se a pessoa é ou não é um estudante com sim/nao");
    boolean approved = this.bilheteria.addPeople(name, age, student.equalsIgnoreCase("sim") ? true : false);
    if (!approved)
      throw new ExceptionControl("pessoa [" + name.toLowerCase() + "] já existe");
  }

  protected void showPeoples() {
    this.bilheteria.showPeoples();
  }

  protected void showEvents() {
    this.bilheteria.showEvents();
  }

  protected void addEvent() throws ExceptionControl {
    String name = this.scanner.next();
    if (name.isEmpty())
      throw new ExceptionControl("você deve informar um nome para o evento");

    boolean approved = this.bilheteria.addEvent(name);
    if (!approved)
      throw new ExceptionControl("o evento [" + name.toLowerCase() + "] já existe.");
  }

  protected void addSector() throws ExceptionControl {
    String eventName = this.scanner.next();
    if (eventName.isEmpty())
      throw new ExceptionControl("você deve informar o nome do evento");

    String sectorName = this.scanner.next();
    if (sectorName.isEmpty())
      throw new ExceptionControl("você deve informar um nome para o setor");
    double price;
    try {
      price = this.scanner.nextDouble();
    } catch (InputMismatchException e) {
      throw new ExceptionControl("você deve informar um número real para o preço do setor");
    }

    int status = this.bilheteria.addSector(eventName, sectorName, price);
    if (status == 0)
      throw new ExceptionControl("o evento informado não existe");
    else if (status == -1)
      throw new ExceptionControl("já existe um setor com o mesmo nome nesse evento");
  }

  protected void sell() throws ExceptionControl {
    String peopleName = this.scanner.next();
    if (peopleName.isEmpty())
      throw new ExceptionControl("você deve informar o nome da pessoa");
    String eventName = this.scanner.next();
    if (eventName.isEmpty())
      throw new ExceptionControl("você deve informar o nome do evento");

    String sectorName = this.scanner.next();
    if (sectorName.isEmpty())
      throw new ExceptionControl("você deve informar o nome do setor");

    int status = this.bilheteria.sell(peopleName, eventName, sectorName);

    if (status == 1)
      throw new ExceptionControl("a pessoa [" + peopleName + "] não existe");
    else if (status == 0)
      throw new ExceptionControl("o evento [" + eventName + "] não existe");
    else if (status == -1)
      throw new ExceptionControl("o setor [" + sectorName + "] não existe no evento [" + eventName + "]");
  }

  protected void showSectors() throws ExceptionControl {
    String eventName = this.scanner.next();
    if (eventName.isEmpty())
      throw new ExceptionControl("você deve informar o nome do evento");
    boolean approved = this.bilheteria.showSectors(eventName);
    if (!approved)
      throw new ExceptionControl("o evento informado não existe");
  }

  protected void showMoney() {
    this.bilheteria.showMoney();
  }

  protected void showSales() {
    this.bilheteria.showSales();
  }

}
