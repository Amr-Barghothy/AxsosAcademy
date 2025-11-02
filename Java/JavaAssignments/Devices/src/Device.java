public class Device {
    private int battery;

    public Device() {
        this.battery = 100;
    }


    public int status() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

}
