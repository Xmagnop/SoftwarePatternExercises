public class Sandwich {
    private String bread;
    private String meat;
    private String cheese;
    private String vegetables;
    private String sauces;
    private String extras;

    public void setBread(String bread) { this.bread = bread; }
    public void setMeat(String meat) { this.meat = meat; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void setVegetables(String vegetables) { this.vegetables = vegetables; }
    public void setSauces(String sauces) { this.sauces = sauces; }
    public void setExtras(String extras) { this.extras = extras; }

    @Override
    public String toString() {
        return "Sandwich {" +
                "Bread='" + bread + '\'' +
                ", Meat='" + meat + '\'' +
                ", Cheese='" + cheese + '\'' +
                ", Vegetables='" + vegetables + '\'' +
                ", Sauces='" + sauces + '\'' +
                ", Extras='" + extras + '\'' +
                '}';
    }
}
