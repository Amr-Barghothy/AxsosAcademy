public class Bat extends Mammal{
    public Bat() {
        this.setEnergy(300);
    }

    public void fly(){
        if(this.getEnergy() < 50){
            System.out.println("The bat doesn't have enough energy");
            return;
        }
        this.setEnergy(this.getEnergy() - 50);
        System.out.println("The bat is in the air");
    }

    public void eatHumans(){
        this.setEnergy(this.getEnergy() + 25);
        System.out.println("The bat is happy with his food human");

    }

    public void attackTown() {
        if(this.getEnergy() < 100){
            System.out.println("The bat doesn't have enough energy");
            return;
        }
        this.setEnergy(this.getEnergy() - 100);
        System.out.println("The bat is attacking the town");
    }
}
