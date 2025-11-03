public class Test {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        Bat bat = new Bat();

        gorilla.climb();
        gorilla.displayEnergy();
        gorilla.throwSomething();
        gorilla.displayEnergy();
        gorilla.eatBananas();
        gorilla.displayEnergy();

        bat.attackTown();
        bat.displayEnergy();
        bat.fly();
        bat.displayEnergy();
        bat.eatHumans();
        bat.displayEnergy();
    }
}
