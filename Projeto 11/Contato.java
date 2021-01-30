import java.util.ArrayList;
import java.util.List;

public class Contato {

    private String name;
    private List<Fone> fones;

    public Contato(String id) {
        this.name = id;
        this.fones = new ArrayList<>();

    }

    public Contato(String id, List<Fone> fones) {
        this.name = id;
        this.fones = fones;
    }

    public String getName() {
        return name;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void addFone(String label, String number) {
        if (Fone.isValid(number))
            this.fones.add(new Fone(label, number));
    }

    public void addFones(List<Fone> fones) {
        for (Fone fone : fones) {
            addFone(fone.getLabel(), fone.getNumber());
        }
    }

    public void removeFone(int index) {
        try {
            this.fones.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Você informou um index que não existe!");
        }
    }

    public void show() {
        System.out.println(this);
    }

    private String getFonesList() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < this.getFones().size(); i++) {
            buffer.append("[").append(i).append(":").append(this.getFones().get(i).toString())
                    .append(i == this.getFones().size() - 1 ? "]" : "] ");
        }
        return buffer.toString();
    }

    public String toString() {
        return "- " + this.getName() + " " + getFonesList();
    }
}
