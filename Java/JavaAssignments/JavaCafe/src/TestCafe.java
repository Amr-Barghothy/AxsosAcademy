import java.util.ArrayList;
import java.util.Scanner;

public class TestCafe {
    public static void main(String[] args) {

    /*
      You will need add 1 line to this file to create an instance
      of the CafeUtil class.
      Hint: it will need to correspond with the variable name used below..
    */
        CafeUtil appTest=new CafeUtil();

        /* ============ App Test Cases ============= */

        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());

        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test-----");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        appTest.printPriceChart("spanish latte",2.0,4);

        ArrayList<String> newmenu = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        newmenu.add("coffee");
        newmenu.add("cappuccino");
        newmenu.add("latte");
        newmenu.add("mocha");
        prices.add(2.1);
        prices.add(4.3);
        prices.add(2.15);
        prices.add(5.2);
        appTest.displayMenu(newmenu,prices);

        Scanner in=new Scanner(System.in);
        ArrayList<String> Temp=new ArrayList<String>();
        appTest.addCustomer(Temp);




    }
}