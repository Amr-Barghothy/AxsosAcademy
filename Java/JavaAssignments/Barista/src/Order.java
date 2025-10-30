import java.util.ArrayList;
public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<>();
    }

    public Order(String name){
        this.name=name;
        this.items = new ArrayList<>();
    }
    public void addItems(Item item){
        this.items.add(item);
        this.total+=item.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOrderTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean getStatusMessage() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    public void displayMenu() {
        System.out.println("\n\nCustomer Name: " + this.name);
        for (Item item : this.items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + this.total + "\n\n");
    }
}
