import java.util.ArrayList;
import java.util.List;

public class Contato {

    private String name;
    private List<Fone> fones;
    private boolean starred;

    public Contato(String id) {
        this.name = id;
        this.fones = new ArrayList<>();
        this.starred = false;
    }

    public Contato(String id, List<Fone> fones) {
        this.name = id;
        this.fones = fones;
        this.starred = false;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public String getName() {
        return name;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void addFone(String label, String number) {
        String alloweds = "().0123456789";
        for (char c : number.toCharArray()) {
            if (alloweds.indexOf(c) < 0) {
                System.out.println("fail: fone inválido");
                return;
            }
        }
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

    private String getFonesList() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < this.fones.size(); i++) {
            buffer.append("[").append(i).append(":").append(this.fones.get(i).toString())
                    .append(i == this.fones.size() - 1 ? "]" : "] ");
        }
        return buffer.toString();
    }

    public void show() {
        System.out.println(this);
    }

    public String toString() {
        return "- " + this.getName() + " " + getFonesList();
    }
}
