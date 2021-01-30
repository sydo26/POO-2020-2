import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jdk.jfr.ContentType;

public class AgendaPlus extends Agenda {
  private Map<String, ContatoPlus> bookmarks;

  public AgendaPlus() {
    super();
    this.bookmarks = new TreeMap<>();
  }

  public boolean starContato(String name) {
    name = name.toLowerCase();
    if (this.contatos.containsKey(name)) {
      Contato contact = this.contatos.get(name);
      ContatoPlus contactPlus = new ContatoPlus(contact.getName(), contact.getFones());
      contactPlus.setStarred(true);
      this.contatos.remove(name);
      this.bookmarks.put(contactPlus.getName(), contactPlus);
      return true;
    } else if (this.bookmarks.containsKey(name)) {
      this.bookmarks.get(name).setStarred(true);
      return true;
    }

    return false;
  }

  public boolean unStarContato(String name) {
    name = name.toLowerCase();
    if (this.bookmarks.containsKey(name)) {
      this.bookmarks.get(name).setStarred(false);
      return true;
    }

    return false;
  }

  public Map<String, Contato> getStarreds() {
    Map<String, Contato> mapTemp = new TreeMap<>();
    for (Map.Entry<String, ContatoPlus> contato : this.bookmarks.entrySet()) {
      if (contato.getValue().isStarred()) {
        mapTemp.put(contato.getKey(), contato.getValue());
      }
    }

    return mapTemp;
  }

  @Override
  public void addContato(String name, List<Fone> fones) {
    if (this.bookmarks.containsKey(name.toLowerCase())) {
      this.bookmarks.get(name.toLowerCase()).addFones(fones);
      return;
    }
    super.addContato(name, fones);
  }

  @Override
  public Contato getContato(String name) {
    name = name.toLowerCase();
    if (this.contatos.containsKey(name))
      return this.contatos.get(name);
    if (this.bookmarks.containsKey(name))
      return this.bookmarks.get(name);
    return null;
  }

  @Override
  public Map<String, Contato> getContatos() {
    Map<String, Contato> mapTemp = new TreeMap<>();
    for (Map.Entry<String, Contato> contato : this.contatos.entrySet()) {
      mapTemp.put(contato.getKey(), contato.getValue());
    }
    for (Map.Entry<String, ContatoPlus> contatoPlus : this.bookmarks.entrySet()) {
      mapTemp.put(contatoPlus.getKey(), contatoPlus.getValue());
    }

    return mapTemp;
  }

  @Override
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

    for (Map.Entry<String, ContatoPlus> contatoPlus : bookmarks.entrySet()) {
      boolean founded = false;
      if (contatoPlus.getKey().contains(pattern))
        founded = true;
      for (Fone fone : contatoPlus.getValue().getFones()) {
        if (fone.getLabel().contains(pattern) || fone.getNumber().contains(pattern))
          founded = true;
      }

      if (founded) {
        searchContato.put(contatoPlus.getKey(), contatoPlus.getValue());
      }
    }

    return searchContato;
  }

  @Override
  public boolean rmContato(String name) {
    name = name.toLowerCase();
    if (this.contatos.containsKey(name)) {
      this.contatos.remove(name);
      return true;
    }

    if (this.bookmarks.containsKey(name)) {
      this.bookmarks.remove(name);
      return true;
    }

    return false;
  }

}
