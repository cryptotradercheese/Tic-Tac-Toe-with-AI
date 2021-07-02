class Cat {

    // write static and instance variables
    public String name;
    public int age;
    public static int counter = 0;

    public Cat(String name, int age) {
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
        this.name = name;
        this.age = age;
    }

    public static int getNumberOfCats() {
        return counter;
    }
}