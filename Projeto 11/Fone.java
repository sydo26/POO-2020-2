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

    public static boolean isValid(String number) {
        String alloweds = "().0123456789";
        for (char c : number.toCharArray()) {
            if (alloweds.indexOf(c) < 0)
                return false;
        }
        return true;
    }

    public String toString() {
        return this.getLabel() + ":" + this.getNumber();
    }
}
