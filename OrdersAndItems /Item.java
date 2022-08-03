import java.util.ArrayList;

//creating data type called order
public class Item {

    //member variables
    private String name;
    private double price;
    private int index;

    public Item(){}
    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    //   and sets them accordingly
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    // GETTERS & SETTERS  - for name and price

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public double getIndex(){
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }
}