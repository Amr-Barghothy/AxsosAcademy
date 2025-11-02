import java.util.ArrayList;

public class CoffeeKiosk {

    ArrayList<Item> menu;
    ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void newOrder() {

        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        addMenuItem("banana",2.00);
        addMenuItem("coffee",1.50);
        addMenuItem("latte",4.50);
        addMenuItem("capuccino",3.00);
        addMenuItem("muffin",4.00);

        // Prompts the user to enter an item number
        displayMenu();
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        // Write a while loop to collect all user's order items
        while (!itemNumber.equals("q")) {
            try {
                int index = Integer.parseInt(itemNumber);
                orders.add(new Order(menu.get(index).getName(), menu.get(index).getPrice()));
            } catch (Exception e) {
                System.out.println("Please select an item from the meny");
            }
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details
        displayOrders(name);
    }

    public void addMenuItem(String name, double price) {
        this.menu.add(new Item(name, price));
    }

    public void displayMenu() {
        for (Item item : this.menu) {
            System.out.println(menu.indexOf(item)+" "+item.getName() + " - $" + item.getPrice());
        }
    }

    public void displayOrders(String name) {
        System.out.println("Thank you " + name +" Here your order details");
        System.out.println("Customer Name " + name);
        for (Order order : orders) {
            System.out.println(order.getName() +" - " + order.getPrice());
        }
        System.out.println("Total: $" + Order.getOrderTotal());
    }

}
