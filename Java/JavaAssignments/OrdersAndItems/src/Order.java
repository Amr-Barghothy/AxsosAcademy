import java.util.ArrayList;
public class Order {
    String name;
    double total;
    boolean ready;

    ArrayList<Item> items=new ArrayList<>();

    public Order(String name,double total,boolean ready,Item items){
        this.name=name;
        this.total=total;
        this.ready=ready;
        this.items.add(items);
    }
    public void addItems(Item item){
        this.items.add(item);
        this.total+=item.price;
    }
}
