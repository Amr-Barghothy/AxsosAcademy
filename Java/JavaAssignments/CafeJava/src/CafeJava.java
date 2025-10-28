public class CafeJava {


    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        double dripCoffe =10.5;
        double latte = 12;
        double cappuccino = 10.1;

        String generalGreeting = "Welcome to Cafe Java, ";

        // Menu variables (add yours below)

        // Customer name variables (add yours below)
        String customer1 = "ADAM";
        String customer2 = "Ahmad";
        String customer3 = "sali";


        // Order completions (add yours below)
        boolean OrderStatus1 = false;
        boolean OrderStatus2 = true;
        boolean OrderStatus3 = true;


        if (OrderStatus2) {
            System.out.println(cappuccino);
        }
        System.out.println(latte);
        if (OrderStatus3){
            System.out.println(OrderStatus3);
        }
        System.out.println("The total: " + (latte + dripCoffe) + " What he owes " + (latte - dripCoffe));







        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Shatha"
        // ** Your customer interaction print statements will go here ** //
    }
}

