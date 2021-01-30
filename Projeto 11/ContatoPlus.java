import java.util.List;

public class ContatoPlus extends Contato {
  private boolean starred;

  public ContatoPlus(String id) {
    super(id);
    this.starred = false;
  }

  public ContatoPlus(String id, List<Fone> fones) {
    super(id, fones);
    this.starred = false;
  }

  public void setStarred(boolean starred) {
    this.starred = starred;
  }

  public boolean isStarred() {
    return starred;
  }

  private String getFonesList() {
    StringBuilder buffer = new StringBuilder();
    for (int i = 0; i < this.getFones().size(); i++) {
      buffer.append("[").append(i).append(":").append(this.getFones().get(i).toString())
          .append(i == this.getFones().size() - 1 ? "]" : "] ");
    }
    return buffer.toString();
  }

  @Override
  public String toString() {
    return (isStarred() ? "@" : "-") + " " + this.getName() + " " + getFonesList();
  }
}