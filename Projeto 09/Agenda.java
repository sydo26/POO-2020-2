import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {

  private Map<String, Contato> contatos;

  public Agenda() {
    this.contatos = new TreeMap<>();
  }

  public void addContato(String name, List<Fone> fones) {
    name = name.toLowerCase();
    if (contatos.containsKey(name)) {
      contatos.get(name).addFones(fones);
      return;
    }

    contatos.put(name, new Contato(name, fones));
  }

  public void show(Map<String, Contato> mapContato) {

    StringBuilder builder = new StringBuilder();
    for (Map.Entry<String, Contato> contato : mapContato.entrySet()) {
      builder.append(contato.getValue().toString()).append("\n");
    }

    System.out.println(builder.toString());
  }

  public Map<String, Contato> getStarreds() {
    Map<String, Contato> mapTemp = new TreeMap<>();
    for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
      if (contato.getValue().isStarred()) {
        mapTemp.put(contato.getKey(), contato.getValue());
      }
    }

    return mapTemp;
  }

  public boolean starContato(String name) {
    name = name.toLowerCase();
    if (this.contatos.containsKey(name)) {
      this.contatos.get(name).setStarred(true);
      return true;
    }

    return false;
  }

  public boolean unStarContato(String name) {
    name = name.toLowerCase();
    if (this.contatos.containsKey(name)) {
      this.contatos.get(name).setStarred(false);
      return true;
    }

    return false;
  }

  public Map<String, Contato> getContatos() {
    return contatos;
  }

  public Contato getContato(String name) {
    for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
      if (contato.getKey().equalsIgnoreCase(name)) {
        return contato.getValue();
      }
    }

    return null;
  }

  public boolean rmContato(String name) {
    for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
      if (contato.getKey().equalsIgnoreCase(name)) {
        this.contatos.remove(contato.getKey());
        return true;
      }
    }

    return false;
  }

  public boolean rmFone(String name, int id) {
    for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
      if (contato.getKey().equalsIgnoreCase(name)) {
        this.contatos.get(contato.getKey()).removeFone(id);
        return true;
      }
    }

    return false;
  }

  public Map<String, Contato> search(String pattern) {
    pattern = pattern.toLowerCase();
    Map<String, Contato> searchContato = new TreeMap<>();

    for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
      boolean founded = false;
      if (contato.getKey().contains(pattern))
        founded = true;
      for (Fone fone : contato.getValue().getFones()) {
        if (fone.getLabel().contains(pattern) || fone.getNumber().contains(pattern))
          founded = true;
      }

      if (founded) {
        searchContato.put(contato.getKey(), contato.getValue());
      }
    }

    return searchContato;
  }
}
