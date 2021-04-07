import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bilheteria {
  private List<Venda> repSales;
  private Map<String, Pessoa> repPeoples;
  private Map<String, Evento> repEvents;
  private double money;

  public Bilheteria() {
    this.repSales = new ArrayList<>();
    this.repPeoples = new TreeMap<>((a, b) -> b.toLowerCase().compareTo(a.toLowerCase()));
    this.repEvents = new TreeMap<>((a, b) -> b.toLowerCase().compareTo(a.toLowerCase()));
    this.money = 0;
  }

  public boolean addPeople(String name, int age, boolean student) {
    name = name.toLowerCase();
    if (this.repPeoples.containsKey(name))
      return false;

    this.repPeoples.put(name, new Pessoa(name, age, student));

    return true;
  }

  public boolean addEvent(String name) {
    name = name.toLowerCase();
    if (this.repEvents.containsKey(name))
      return false;

    this.repEvents.put(name, new Evento(name));

    return true;
  }

  public int addSector(String eventName, String sectorName, double price) {
    // 1 = Sucesso
    // 0 = Evento inexistente
    // -1 = Já existe um setor com o mesmo nome no evento

    eventName = eventName.toLowerCase();
    sectorName = sectorName.toLowerCase();
    if (!this.repEvents.containsKey(eventName))
      return 0;

    boolean approved = this.repEvents.get(eventName).addSector(new Setor(sectorName, price));
    if (approved)
      return 1;

    return 0;
  }

  public int sell(String peopleName, String eventName, String sectorName) {
    // 2 = sucesso
    // 1 = Pessoa não existe
    // 0 = evento não existe
    // -1 = setor não existe
    if (!this.repPeoples.containsKey(peopleName))
      return 1;
    if (!this.repEvents.containsKey(eventName))
      return 0;
    if (!this.repEvents.get(eventName).getRepSectors().containsKey(sectorName))
      return -1;

    Venda sale = new Venda(this.repPeoples.get(peopleName), this.repEvents.get(eventName),
        this.repEvents.get(eventName).getRepSectors().get(sectorName));
    sale.filterPrice();
    this.repSales.add(sale);
    this.money += sale.getValue();
    return 2;
  }

  public void showPeoples() {
    for (Map.Entry<String, Pessoa> peopleEntry : this.repPeoples.entrySet()) {
      System.out.println(peopleEntry.getValue().toString());
    }
  }

  public void showEvents() {
    for (Map.Entry<String, Evento> eventsEntry : this.repEvents.entrySet()) {
      System.out.println(eventsEntry.getValue().toString());
    }
  }

  public boolean showSectors(String eventName) {
    eventName = eventName.toLowerCase();
    if (!this.repEvents.containsKey(eventName))
      return false;

    for (Map.Entry<String, Setor> sectors : this.repEvents.get(eventName).getRepSectors().entrySet()) {
      System.out.println(sectors.getValue().toString());
    }

    return true;
  }

  public void showMoney() {
    System.out.println(String.format("R$ %.2f", this.money));
  }

  public void showSales() {
    for (Venda sale : this.repSales) {
      System.out.println(sale.toString());
    }
  }

}