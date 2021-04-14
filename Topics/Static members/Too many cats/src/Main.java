class Cat {

    static int counter;
    // write static and instance variables
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (counter > 5) System.out.println("You have too many cats");
    }

    public static int getNumberOfCats() {
        return counter;
    }
}