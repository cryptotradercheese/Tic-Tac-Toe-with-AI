class Employee {

    // write fields
    String name;
    protected String email;
    protected int experience;

    // write constructor
    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // write getters
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getExperience() {
        return this.experience;
    }
}

class Developer extends Employee {
    protected String mainLanguage;
    protected String[] skills;

    // write constructor
    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    // write getters
    public String getMainLanguage() {
        return this.mainLanguage;
    }

    public String[] getSkills() {
        return this.skills;
    }
}

class DataAnalyst extends Employee {
    boolean phd;
    String[] methods;

    // write constructor
    public DataAnalyst(String name, String email, int experience, Boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }

    // write getters

    public boolean isPhd() {
        return this.phd;
    }

    public String[] getMethods() {
        return this.methods;
    }
}