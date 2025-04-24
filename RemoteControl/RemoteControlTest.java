public class RemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Tv bedRoomTv = new Tv("BedRoom");

        remote.setCommand(
            0,
            () -> livingRoomLight.on(),
            () -> livingRoomLight.off()
        );

        remote.setCommand(
            2,
            () -> bedRoomTv.on(),
            () -> bedRoomTv.off()
        );

        System.out.println(remote);

        remote.onButtonWasPushed(0);  // Liga a luz
        remote.onButtonWasPushed(2);  // Liga Tv
        remote.offButtonWasPushed(0); // Desliga a luz
        remote.undoButtonWasPushed(); // Desfaz o último (liga de novo)
    }
}
