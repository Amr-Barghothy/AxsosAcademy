public class DeviceTest {

    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println(phone.status());
        phone.makeCall();
        phone.makeCall();
        phone.makeCall();
        System.out.println(phone.status());
        phone.playGame();
        phone.playGame();
        System.out.println(phone.status());
        phone.charge();
        System.out.println(phone.status());
    }
}
