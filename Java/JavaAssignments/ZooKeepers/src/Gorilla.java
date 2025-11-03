public class Gorilla extends Mammal {

    public void throwSomething() {
        if(this.getEnergy() < 5) {
            System.out.println("The gorilla doesn't have enough energy");
            return;
        }
        this.setEnergy(this.getEnergy() - 5);
        System.out.println("The Gorilla threw something");
    }

    public void eatBananas() {
        this.setEnergy(this.getEnergy() + 10);
        System.out.println("The Gorilla is happy");
    }

    public void climb() {
        if(this.getEnergy() < 10) {
            System.out.println("The gorilla doesn't have enough energy");
            return;
        }
        this.setEnergy(this.getEnergy() - 10);
        System.out.println("The Gorilla climbed a tree");
    }
}
