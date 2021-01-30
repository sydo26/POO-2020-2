public class Venda {
  private Pessoa client;
  private Evento event;
  private Setor sector;
  private double value;

  public Venda(Pessoa client, Evento event, Setor sector) {
    this.client = client;
    this.event = event;
    this.sector = sector;
    this.value = 0;
  }

  public void filterPrice() {
    if ((this.client.getAge() > 2 && this.client.getAge() <= 12) || this.client.isStudent())
      this.value = this.sector.getPrice() / 2;
    else if (this.client.getAge() > 12)
      this.value = this.sector.getPrice();
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return (new StringBuilder()).append("[").append(client.getName()).append(", ").append(this.event.getName())
        .append(", ").append(this.sector.getName()).append(", ").append("R$ " + String.format("%.2f", this.value))
        .append("]").toString();
  }
}
