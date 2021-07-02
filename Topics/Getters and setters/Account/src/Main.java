class Account {

    private long balance;
    private String ownerName;
    private boolean locked;

    public long getBalance() {
        return this.balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return this.ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isLocked() {
        return this.locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}