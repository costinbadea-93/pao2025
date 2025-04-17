package model;

public enum AccountType {
    SAVINGS("Savings is a way to save your money with a 3.5% interest rate"),
    DEPOSITS("Deposits is a way to save your money for 1, 3 and 5 years with a " +
            "4.5% starting interest rate");

    private String accountDescription;

    AccountType(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }
}
