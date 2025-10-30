public class TestOrder {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 =new Order();
        Order order3 = new Order("Amr");
        Order order4 = new Order("Khaled");
        Order order5 = new Order("Ibrahim");

        Item item1 = new Item("latte", 10);
        Item item2 = new Item("Ice Coffee", 8);

        Item item3 = new Item("Mocha", 15);
        Item item4 = new Item("matcha", 20);

        Item item5 = new Item("Spanish latte", 18);
        Item item6 = new Item("frappuccino", 13);

        Item item7 = new Item("Strawberry MilkTea", 17);
        Item item8 = new Item("Hot Chocolate", 16);

        Item item9 = new Item("Vanilla chai", 6);
        Item item10 = new Item("Coffee", 4);

        order1.addItems(item1);
        order1.addItems(item2);

        order2.addItems(item3);
        order2.addItems(item4);

        order3.addItems(item5);
        order3.addItems(item6);

        order4.addItems(item7);
        order4.addItems(item8);

        order5.addItems(item9);
        order5.addItems(item10);

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getOrderTotal());

        order1.displayMenu();
        order2.displayMenu();
        order3.displayMenu();
        order4.displayMenu();
        order5.displayMenu();
    }
}
