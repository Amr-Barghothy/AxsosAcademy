public class TestOrder {
    public static void main(String[] args) {
        Item item1=new Item("mocha",15.5);
        Item item2=new Item("latte",1.3);
        Item item3=new Item("Drip Coffee",3.3);
        Item item4=new Item("cappuccino",2.2);

        Order order1=new Order("Rami",item1.price,false,item1);
        Order order2=new Order("Jimmy",item2.price,false,item2);
        Order order3=new Order("Noah",item3.price, true, item3);
        Order order4=new Order("Sam",item4.price,false,item4);
        System.out.println(order1);
        System.out.println(order1.total);
        order2.addItems(item1);
        order3.addItems(item4);
        order4.addItems(item2);
        order4.addItems(item2);
        order4.addItems(item2);
        order1.ready=true;
        order2.ready=true;
    }
}
