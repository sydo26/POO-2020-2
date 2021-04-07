public enum AccountType {
    CC("CC"), CP("CP");

    private String value;

    private AccountType(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }
}
