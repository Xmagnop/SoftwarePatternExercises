public class UnlockedState implements PhoneState {
    private SmartPhone phone;

    public UnlockedState(SmartPhone phone) {
        this.phone = phone;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Bloqueando o celular...");
        phone.setState(new LockedState(phone));
    }

    @Override
    public void receiveCall() {
        System.out.println("Recebendo chamada...");
        phone.setPreviousState(this);
        phone.setState(new RingingState(phone));
    }

    @Override
    public void takePicture() {
        System.out.println("Tirando foto...");
    }

    @Override
    public void toggleSilentMode() {
        System.out.println("Ativando modo silencioso.");
        phone.setState(new SilentState(phone));
    }
}
