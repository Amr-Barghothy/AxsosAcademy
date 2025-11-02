import java.util.ArrayList;
public class Order {
    private String name;
    private double price;
    private static double total;

    public Order() {
        this.name = "Guest";
    }

    public Order(String name, double price){
        this.name=name;
        this.price=price;
        total+=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public static double getOrderTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.price = total;
    }
}
