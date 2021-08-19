public class Lamp implements Switch{

    @Override
    public void turnOn() {
        System.out.println("đã bật");
    }

    @Override
    public void turnOff() {
        System.out.println("đã tắt");
    }
}
