class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "";
        }
    }

    public String getFullName() {
        String fullName = "Unknown";
        if ("".equals(this.firstName) && !"".equals(this.lastName)) {
            fullName = lastName;
        } else if ("".equals(this.lastName) && !"".equals(this.firstName)) {
            fullName = firstName;
        } else if (!"".equals(this.firstName) && !"".equals(this.lastName)) {
            fullName = this.firstName + " " + this.lastName;
        }
        return fullName; // write your code here
    }
}