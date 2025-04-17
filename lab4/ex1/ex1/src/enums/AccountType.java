package enums;

public enum AccountType  {
    /**
     * nu putem extinde clase
     * dar putem implementa alte interfete
     */

    SAVINGS("Savings account description"){
        @Override
        public void printAccountDescription() {
            System.out.println("Savings account description");
        }
    },
    DEPOSITS("Deposits account description");

    private String accountDescription;

    AccountType(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public void printAccountDescription() {
        System.out.println("Default Account Description");
    }

}
