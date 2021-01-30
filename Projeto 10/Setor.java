public class Setor {
  private String name;
  private double price;

  public Setor(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return (new StringBuilder()).append("[").append(this.getName()).append("]").toString();
  }
}
