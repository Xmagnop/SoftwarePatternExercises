public class Tv {
    private String location;

    public Tv(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Tv is ON");
    }

    public void off() {
        System.out.println(location + " Tv is OFF");
    }
}
