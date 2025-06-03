public class LockedState implements PhoneState {
    private SmartPhone phone;

    public LockedState(SmartPhone phone) {
        this.phone = phone;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Desbloqueando o celular...");
        phone.setState(new UnlockedState(phone));
    }

    @Override
    public void receiveCall() {
        System.out.println("O celular está bloqueado. Chamada recebida silenciosamente.");
    }

    @Override
    public void takePicture() {
        System.out.println("Desbloqueie o celular para usar a câmera.");
    }

    @Override
    public void toggleSilentMode() {
        System.out.println("Ativando modo silencioso com o celular bloqueado.");
        phone.setState(new SilentState(phone));
    }
}
