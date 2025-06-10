public class SilentState implements PhoneState {
    private SmartPhone phone;

    public SilentState(SmartPhone phone) {
        this.phone = phone;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Bloqueando o celular...");
        phone.setState(new LockedState(phone));
    }

    @Override
    public void receiveCall() {
        System.out.println("Recebendo chamada em modo silencioso...");
        phone.setPreviousState(this);
        phone.setState(new RingingState(phone));
    }

    @Override
    public void takePicture() {
        System.out.println("Tirando foto silenciosamente...");
    }

    @Override
    public void toggleSilentMode() {
        System.out.println("Desativando modo silencioso.");
        phone.setState(new UnlockedState(phone));
    }
}
