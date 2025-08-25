
    void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount);
    }