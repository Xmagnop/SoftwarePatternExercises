// LanchoneteTest.java

// ===== Interfaces dos Ingredientes =====
interface Bread {
    String getName();
}

interface Cheese {
    String getName();
}

interface Ham {
    String getName();
}

interface Salad {
    String getName();
}

// ===== Implementações de Pães =====
class WhiteBread implements Bread {
    public String getName() {
        return "Pão Francês";
    }
}

class WholeGrainBread implements Bread {
    public String getName() {
        return "Pão Integral";
    }
}

class BallBread implements Bread {
    public String getName() {
        return "Pão Bola";
    }
}

// ===== Implementações de Queijos =====
class PratoCheese implements Cheese {
    public String getName() {
        return "Queijo Prato";
    }
}

class MozzarellaCheese implements Cheese {
    public String getName() {
        return "Queijo Mussarela";
    }
}

class CheddarCheese implements Cheese {
    public String getName() {
        return "Queijo Cheddar";
    }
}

// ===== Implementações de Presuntos =====
class ChickenHam implements Ham {
    public String getName() {
        return "Presunto de Frango";
    }
}

class TurkeyHam implements Ham {
    public String getName() {
        return "Presunto de Peru";
    }
}

// ===== Implementações de Salada =====
class SaladWithVeggies implements Salad {
    public String getName() {
        return "Salada com Verdura";
    }
}

class SaladWithoutVeggies implements Salad {
    public String getName() {
        return "Salada sem Verdura";
    }
}

// ===== Abstract Sandwich Factory =====
interface SandwichIngredientFactory {
    Bread createBread();
    Cheese createCheese();
    Ham createHam();
    Salad createSalad();
}

// ===== Fábricas Concretas =====
class CGSandwichFactory implements SandwichIngredientFactory {
    public Bread createBread() {
        return new WholeGrainBread();
    }

    public Cheese createCheese() {
        return new PratoCheese();
    }

    public Ham createHam() {
        return new ChickenHam();
    }

    public Salad createSalad() {
        return new SaladWithoutVeggies();
    }
}

class JPSandwichFactory implements SandwichIngredientFactory {
    public Bread createBread() {
        return new WhiteBread();
    }

    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    public Ham createHam() {
        return new ChickenHam();
    }

    public Salad createSalad() {
        return new SaladWithVeggies();
    }
}

class RTSandwichFactory implements SandwichIngredientFactory {
    public Bread createBread() {
        return new BallBread();
    }

    public Cheese createCheese() {
        return new CheddarCheese();
    }

    public Ham createHam() {
        return new TurkeyHam();
    }

    public Salad createSalad() {
        return new SaladWithoutVeggies();
    }
}

// ===== Classe Abstrata do Sanduíche =====
abstract class Sandwich {
    protected Bread bread;
    protected Cheese cheese;
    protected Ham ham;
    protected Salad salad;

    public abstract void prepare();

    public void showIngredients() {
        System.out.println("Sanduíche com:");
        System.out.println("- Pão: " + bread.getName());
        System.out.println("- Queijo: " + cheese.getName());
        System.out.println("- Presunto: " + ham.getName());
        System.out.println("- Salada: " + salad.getName());
    }
}

// ===== Tipos de Sanduíches =====
class CGSandwich extends Sandwich {
    private SandwichIngredientFactory factory;

    public CGSandwich(SandwichIngredientFactory factory) {
        this.factory = factory;
    }

    public void prepare() {
        bread = factory.createBread();
        cheese = factory.createCheese();
        ham = factory.createHam();
        salad = factory.createSalad();
    }
}

class JPSandwich extends Sandwich {
    private SandwichIngredientFactory factory;

    public JPSandwich(SandwichIngredientFactory factory) {
        this.factory = factory;
    }

    public void prepare() {
        bread = factory.createBread();
        cheese = factory.createCheese();
        ham = factory.createHam();
        salad = factory.createSalad();
    }
}

class RTSandwich extends Sandwich {
    private SandwichIngredientFactory factory;

    public RTSandwich(SandwichIngredientFactory factory) {
        this.factory = factory;
    }

    public void prepare() {
        bread = factory.createBread();
        cheese = factory.createCheese();
        ham = factory.createHam();
        salad = factory.createSalad();
    }
}

// ===== Main =====
public class LanchoneteTest {
    public static void main(String[] args) {
        System.out.println("Sanduíche CG:");
        Sandwich cg = new CGSandwich(new CGSandwichFactory());
        cg.prepare();
        cg.showIngredients();

        System.out.println("\nSanduíche JP:");
        Sandwich jp = new JPSandwich(new JPSandwichFactory());
        jp.prepare();
        jp.showIngredients();

        System.out.println("\nSanduíche RT:");
        Sandwich rt = new RTSandwich(new RTSandwichFactory());
        rt.prepare();
        rt.showIngredients();
    }
}
