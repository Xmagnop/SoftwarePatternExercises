public class SandwichBuilder implements Builder {
    private Sandwich sandwich;

    public SandwichBuilder() {
        this.sandwich = new Sandwich();
    }

    public void buildBread() {
        sandwich.setBread("Whole Grain");
    }

    public void buildMeat() {
        sandwich.setMeat("Turkey");
    }

    public void buildCheese() {
        sandwich.setCheese("Swiss");
    }

    public void buildVegetables() {
        sandwich.setVegetables("Lettuce, Tomato, Onion");
    }

    public void buildSauces() {
        sandwich.setSauces("Mayonnaise, Mustard");
    }

    public void buildExtras() {
        sandwich.setExtras("Olives, Pickles");
    }

    public Sandwich getSandwich() {
        return sandwich;
    }
}
