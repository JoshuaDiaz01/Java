import java.util.ArrayList;
public class CafeUtil {
    // getting streak goal
    public int getStreakGoal(){
        int sum = 0;
        for(int i=0; i<=10; i++){
            sum += i;
        }
        return sum;
    }


    public double getOrderTotal(double[] prices){
        double total = 0;
        System.out.println(prices.length);
        for (int i=0; i<prices.length; i++){
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuitems){
        for (int i=0; i<menuitems.size(); i++){
            String item = menuitems.get(i);
            System.out.println(i + " " + item);
        }
    }

    public void addCustomer(ArrayList<String> customers){
        int num = customers.size();
        System.out.println("Please enter your name here:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!", userName);
        System.out.printf("There are %s people in front of you.", num);
        customers.add(userName);
        System.out.println(customers);
    }





}