import java.util.ArrayList;

//creating data type called order
public class Order {
    //member variables always private
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(){
        this.name = "guest";
        this.ready = false;
    }
    public Order(String name){
        this.name = name;
        this.ready = false;
    }

    // setting methods for member variables
    public String getName(){
        return this.name;
    }
    public boolean getReady(){
        return this.ready;
    }
    public ArrayList<Item> getItems(){
        return items;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    // implementing add items
    public void addItem(Item item){
        this.items.add(item);
    }

    // get status message
    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready.";
        } else{
            return "thank you for waiting, your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double total = 0.0;
        for (Item i : this.items){
            total += i.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Costumer Name: %s", this.name);
        for (Item i: this.items){
            System.out.println(" " + i.getName() + " -$" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }


}