public class Lamp implements Switch, ITest{

    @Override
    public void turnOn() {
        System.out.println("đã bật");
    }

    @Override
    public void turnOff() {
        System.out.println("đã tắt");
    }

    @Override
    public void A() {
        System.out.println("A");
    }
}
