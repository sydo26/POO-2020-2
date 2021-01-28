public class Fone {
    private String label;
    private String number;

    public Fone(String label, String number) {
        this.label = label;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public String getNumber() {
        return number;
    }

    public boolean isValid(String number) {
        return this.number.equalsIgnoreCase(number);
    }
    
    public String toString() {
        return this.getLabel() + ":" + this.getNumber();
    }
}
