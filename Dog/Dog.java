public class Dog {
    private String name;
    private int age;
    private String hairColor;


    // Constructor
    // notice no return type
    // equivalent of __init__ in python
    // dunder init, dunder = shorthand for double underscore
    public Dog() {
        this.name = "Default";
        this.age = 5;
        this.hairColor = "brown";
    }

    public Dog(String name) {
        this.name = name;
        this.age = 5;
        this.hairColor = "brown";
    }

    // public Dog(int age) {
    //     this.name = name;
    //     this.age = 5;
    //     this.hairColor = "brown";
    // }

    public Dog(String name, int age, String hairColor) {
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
    }

    // METHODS

    public void bark() {
        System.out.println("Bark bark my name is " + this.name);
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age < age) {
            this.age = age;
        }
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}