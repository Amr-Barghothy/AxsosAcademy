import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CafeUtil {

    public int getStreakGoal(){
        int sum=0;
        for (int i=1;i<=10;i++) sum+=i;
        return sum;
    }
    public int getStreakGoal(int numWeeks){
        int sum=0;
        for (int i=1;i<=numWeeks;i++) sum+=i;
        return sum;
    }
    public double getOrderTotal(double[] prices){
        double sum=0.0;
        for(double price:prices){
            sum+=price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println("index = "+i+"menuItems = " + menuItems.get(i));
        }

    }
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if(menuItems.size()!=prices.size())return false;
        String menu="index  "+"menuItems "+"  Price"+"\n";
        for (int i = 0; i < menuItems.size(); i++) {
            menu+=String.format("%d    %s    -  $%f \n",i,menuItems.get(i),prices.get(i));
        }
        System.out.println(menu);
        return true;
    }


    public void addCustomer(ArrayList<String> customers){
        System.out.println("Enter your name please or q to exit");
        Scanner in =new Scanner(System.in);
        while(true){
            String username=in.next();
            if(username.equals("q"))break;
//            System.out.printf("Hello, %s \n",username);
            System.out.printf("There are %d people in front of you \n",customers.size());
            customers.add(username);
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        double total=price;
        for (int i = 1; i <=maxQuantity; i++) {
//            System.out.println(i+"-"+" $"+price*i);
            if (i == 1) {
                System.out.println(String.format("%d- $%f",i,price));
                total=price;
            }
            else {

                System.out.println(String.format("%d- $%f", i, (price * i - (i - 1) * 0.5)));
            }

        }

    }

}