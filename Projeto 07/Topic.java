import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;

public class Topic {
  private List<Pass> cadeiras;
  private int cadeirasSize = 0;
  private int qtdPref;
  private int lotacao;

  public boolean subir(Pass pass) {
    for (Pass p : this.getCadeiras()) {
      if (p != null) {
        if (p.getName().equalsIgnoreCase(pass.getName())) {
          System.out.println("fail: pass ja esta na topic");
          return false;
        }
      }
    }

    if (this.getCadeirasSize() < this.getLotacao()) {
      if (!pass.isPref()) {
        for (int i = this.getQtdPref(); i < this.getLotacao(); i++) {
          if (this.getCadeiras().get(i) == null) {
            this.cadeiras.set(i, pass);
            this.cadeirasSize += 1;
            return true;
          }
        }
      }

      for (int i = 0; i < this.getLotacao(); i++) {
        if (this.getCadeiras().get(i) == null) {
          this.cadeiras.set(i, pass);
          this.cadeirasSize += 1;
          return true;
        }
      }
    } else {
      System.out.println("fail: topic lotada");
    }

    return false;
  }

  public boolean descer(String name) {
    if (this.getCadeirasSize() > 0) {
      for (int i = 0; i < this.getLotacao(); i++) {
        Pass pass = this.getCadeiras().get(i);
        if (pass != null) {
          if (pass.getName().equalsIgnoreCase(name)) {
            this.cadeiras.set(i, null);
            this.cadeirasSize -= 1;
            return true;
          }
        }
      }

      System.out.println("fail: pass nao esta na topic");
    } else {
      System.out.println("fail: topic vazia");
    }

    return false;
  }

  public Topic() {
    this.lotacao = 0;
    this.qtdPref = 0;
  }

  public Topic(int lotacao, int qtdPref) {
    this.cadeiras = new ArrayList<>(lotacao);
    for (int i = 0; i < lotacao; i++)
      this.cadeiras.add(null);
    this.lotacao = lotacao;
    this.qtdPref = qtdPref;
  }

  public int getQtdPref() {
    return qtdPref;
  }

  public List<Pass> getCadeiras() {
    return cadeiras;
  }

  public int getLotacao() {
    return lotacao;
  }

  public int getCadeirasSize() {
    return cadeirasSize;
  }

  public void show() {
    System.out.println(this.toString());
  }

  public String toString() {
    List<String> list = new ArrayList<>(this.getLotacao());

    for (int i = 0; i < this.getLotacao(); i++) {
      Pass pass = this.getCadeiras().get(i);
      if (i > this.getQtdPref() - 1) {
        list.add("=" + (pass != null ? pass.toString() : ""));
      } else {
        list.add("@" + (pass != null ? pass.toString() : ""));
      }
    }

    return "[ " + list.stream().map(Object::toString).collect(Collectors.joining(" ")) + " ]";
  }
}
