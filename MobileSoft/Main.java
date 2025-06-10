public class Main {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        phone.takePicture();           // Deve informar que está bloqueado
        phone.pressPowerButton();      // Desbloqueia
        phone.takePicture();           // Tira foto
        phone.toggleSilentMode();      // Vai para modo silencioso
        phone.receiveCall();           // Vai para modo ringing
        phone.pressPowerButton();      // Recusa chamada e volta para Silent
        phone.toggleSilentMode();      // Sai do modo silencioso
    }
}
