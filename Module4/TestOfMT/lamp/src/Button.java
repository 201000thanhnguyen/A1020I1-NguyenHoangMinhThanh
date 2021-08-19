public class Button {

    private Switch aSwitch;
    private boolean isOn;

    public Switch getaSwitch() {
        return aSwitch;
    }

    public void setaSwitch(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public Button() {
    }

    public Button(Switch aSwitch, boolean isOn) {
        this.aSwitch = aSwitch;
        this.isOn = isOn;
    }

    public void poll(){
        if (isOn){
            this.aSwitch.turnOn();
        }else {
            this.aSwitch.turnOff();
        }
    }

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Button button = new Button(lamp, false);
        button.poll();
    }
}
