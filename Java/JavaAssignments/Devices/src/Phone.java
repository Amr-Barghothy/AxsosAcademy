public class Phone extends Device {


    public void makeCall() {
        if (this.status() < 5) {
            System.out.println("You can't make a call");
            return;
        }
        this.setBattery(this.status() - 5);
    }

    public void playGame() {
        if (this.status() < 25) {
            System.out.println("You can't play a game");
            return;
        }
        this.setBattery(this.status() - 20);
        if (this.status() < 10) {
            System.out.println("battery critical");
        }
    }

    public void charge() {
        if (this.status() + 50 > 100) {
            this.setBattery(this.status() + (100 - this.status()));
        }
        else {
            this.setBattery(this.status() + 50);
        }
    }
}
