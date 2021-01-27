import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Agenda {

  private List<Contato> contatos;

  public void addContato(String name, List<Fone> fones) {
    for (int i = 0; i < contatos.size(); i++) {
      if (contatos.get(i).getName().equalsIgnoreCase(name)) {
        this.contatos.get(i).addFones(fones);
        return;
      }
    }

    this.contatos.add(new Contato(name, fones));
  }

  public void show(List<Contato> listContato) {

    Collections.sort(listContato, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

    StringBuilder builder = new StringBuilder();
    for (Contato contato : listContato) {
      builder.append("- " + contato.getName());
      for (int i = 0; i < contato.getFones().size(); i++) {
        builder.append(" [" + i + ":" + contato.getFones().get(i).toString() + "]");
      }
      builder.append("\n");
    }

    System.out.println(builder.toString());
  }

  public List<Contato> getContatos() {
    return contatos;
  }

  public Contato getContato(String name) {
    for (Contato contato : contatos) {
      if (contato.getName().equalsIgnoreCase(name)) {
        return contato;
      }
    }
    return null;
  }

  public boolean rmContato(String name) {
    for (int i = 0; i < contatos.size(); i++) {
      if (contatos.get(i).getName().equalsIgnoreCase(name)) {
        this.contatos.remove(contatos.get(i));
        return true;
      }
    }

    return false;
  }

  public boolean rmFone(String name, int id) {
    for (int i = 0; i < contatos.size(); i++) {
      if (contatos.get(i).getName().equalsIgnoreCase(name)) {
        this.contatos.get(i).removeFone(id);
        return true;
      }
    }

    return false;
  }

  public Agenda() {
    this.contatos = new ArrayList<>();
  }

  public List<Contato> search(String pattern) {
    List<Contato> searchContato = new ArrayList<>();

    for (Contato contato : contatos) {
      boolean founded = false;
      if (contato.getName().contains(pattern))
        founded = true;
      for (Fone fone : contato.getFones()) {
        if (fone.getLabel().contains(pattern) || fone.getNumber().contains(pattern))
          founded = true;
      }

      if (founded) {
        searchContato.add(contato);
      }
    }

    return searchContato;
  }
}
