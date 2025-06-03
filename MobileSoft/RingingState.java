public class RingingState implements PhoneState {
    private SmartPhone phone;

    public RingingState(SmartPhone phone) {
        this.phone = phone;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Chamada recusada. Voltando ao estado anterior.");
        phone.setState(phone.getPreviousState());
    }

    @Override
    public void receiveCall() {
        System.out.println("Já está tocando...");
    }

    @Override
    public void takePicture() {
        System.out.println("Não é possível tirar foto durante uma chamada.");
    }

    @Override
    public void toggleSilentMode() {
        System.out.println("Não é possível mudar o modo durante uma chamada.");
    }
}
