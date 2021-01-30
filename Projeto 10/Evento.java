import java.util.Map;
import java.util.TreeMap;

public class Evento {
  private String name;
  private Map<String, Setor> repSectors;

  public Evento(String name) {
    this.name = name;
    this.repSectors = new TreeMap<>();
  }

  public String getName() {
    return name;
  }

  public Map<String, Setor> getRepSectors() {
    return repSectors;
  }

  public boolean addSector(Setor sector) {
    if (this.repSectors.containsKey(sector.getName()))
      return false;

    this.repSectors.put(sector.getName(), sector);

    return true;
  }

  @Override
  public String toString() {
    return (new StringBuilder()).append("[").append(this.getName()).append("]").toString();
  }
}
