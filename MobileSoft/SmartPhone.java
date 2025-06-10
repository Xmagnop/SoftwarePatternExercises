public class SmartPhone {
    private PhoneState state;
    private PhoneState previousState;

    public SmartPhone() {
        this.state = new LockedState(this);
        this.previousState = null;
    }

    public void setState(PhoneState state) {
        this.state = state;
    }

    public void setPreviousState(PhoneState state) {
        this.previousState = state;
    }

    public PhoneState getPreviousState() {
        return previousState != null ? previousState : new LockedState(this);
    }

    // Métodos públicos que delegam para o estado atual
    public void pressPowerButton() {
        state.pressPowerButton();
    }

    public void receiveCall() {
        state.receiveCall();
    }

    public void takePicture() {
        state.takePicture();
    }

    public void toggleSilentMode() {
        state.toggleSilentMode();
    }
}
