// Classe base Beverage
abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI } // Enum para os tamanhos
    protected Size size;
    protected String description = "Unknown Beverage";

    public Beverage(Size size) {
        this.size = size;
    }

    public String getDescription() {
        return description + " (" + size.toString().toLowerCase() + ")";
    }

    public Size getSize() {
        return size;
    }

    public abstract double cost();
}

// Classe abstrata CondimentDecorator que herda de Beverage
abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        super(beverage.getSize()); // Passa o tamanho do beverage decorado
        this.beverage = beverage;
    }

    public abstract String getDescription();
}

// Implementação de Espresso
class Espresso extends Beverage {
    public Espresso(Size size) {
        super(size);
        description = "Espresso";
    }

    @Override
    public double cost() {
        switch (size) {
            case TALL:
                return 1.99;
            case GRANDE:
                return 2.49;
            case VENTI:
                return 2.99;
            default:
                return 0.0;
        }
    }
}

// Implementação de HouseBlend
class HouseBlend extends Beverage {
    public HouseBlend(Size size) {
        super(size);
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        switch (size) {
            case TALL:
                return 0.89;
            case GRANDE:
                return 1.09;
            case VENTI:
                return 1.29;
            default:
                return 0.0;
        }
    }
}

// Implementação do condimento Mocha
class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        switch (beverage.getSize()) {
            case TALL:
                cost += 0.20;
                break;
            case GRANDE:
                cost += 0.25;
                break;
            case VENTI:
                cost += 0.30;
                break;
        }
        return cost;
    }
}

// Implementação do condimento Soy
class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        switch (beverage.getSize()) {
            case TALL:
                cost += 0.10;
                break;
            case GRANDE:
                cost += 0.15;
                break;
            case VENTI:
                cost += 0.20;
                break;
        }
        return cost;
    }
}

// Implementação do condimento Whip
class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        switch (beverage.getSize()) {
            case TALL:
                cost += 0.10;
                break;
            case GRANDE:
                cost += 0.15;
                break;
            case VENTI:
                cost += 0.20;
                break;
        }
        return cost;
    }
}

public class StarBuzzCoffee {
    public static void main(String[] args) {
        // Criando um Espresso tall
        Beverage espressoTall = new Espresso(Beverage.Size.TALL);
        System.out.println(espressoTall.getDescription() + " $" + String.format("%.2f", espressoTall.cost()));

        // Criando um Espresso grande
        Beverage espressoGrande = new Espresso(Beverage.Size.GRANDE);
        System.out.println(espressoGrande.getDescription() + " $" + String.format("%.2f", espressoGrande.cost()));

        // Criando um Espresso venti
        Beverage espressoVenti = new Espresso(Beverage.Size.VENTI);
        System.out.println(espressoVenti.getDescription() + " $" + String.format("%.2f", espressoVenti.cost()));

        // Criando um HouseBlend grande com Mocha e Whip
        Beverage houseBlendGrande = new HouseBlend(Beverage.Size.GRANDE);
        houseBlendGrande = new Mocha(houseBlendGrande); // Adiciona Mocha
        houseBlendGrande = new Whip(houseBlendGrande); // Adiciona Whip
        System.out.println(houseBlendGrande.getDescription() + " $" + String.format("%.2f", houseBlendGrande.cost()));

        // Criando um Espresso venti com Soy e Mocha
        Beverage espressoVentiDecorated = new Espresso(Beverage.Size.VENTI);
        espressoVentiDecorated = new Soy(espressoVentiDecorated); // Adiciona Soy
        espressoVentiDecorated = new Mocha(espressoVentiDecorated); // Adiciona Mocha
        System.out.println(espressoVentiDecorated.getDescription() + " $" + String.format("%.2f", espressoVentiDecorated.cost()));
    }
}