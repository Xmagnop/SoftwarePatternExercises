public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void constructSandwich() {
        builder.buildBread();
        builder.buildMeat();
        builder.buildCheese();
        builder.buildVegetables();
        builder.buildSauces();
        builder.buildExtras();
    }
}
