public class Main {
    public static void main(String[] args) {
        Builder builder = new SandwichBuilder();
        Director director = new Director(builder);

        director.constructSandwich();

        Sandwich sandwich = builder.getSandwich();
        System.out.println(sandwich);
    }
}
