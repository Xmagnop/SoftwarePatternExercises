// Interface para as estratégias de desconto
interface ISalePricingStrategy {
    double getTotal(Sale sale);
}

// Estratégia de Desconto Percentual
class PercentDiscount implements ISalePricingStrategy {
    private final double percentage;

    public PercentDiscount() {
        this.percentage = 15;
    }

    @Override
    public double getTotal(Sale sale) {
        double totalSale = sale.gettotalSale();
        double discountAmount = totalSale * (percentage / 100);
        return totalSale - discountAmount; // Aplica o desconto percentual
    }
}

// Estratégia de Desconto Absoluto Acima de um Limite
class AbsoluteDiscountOverThreshold implements ISalePricingStrategy {
    private final double discount;
    private final double threshold;

    public AbsoluteDiscountOverThreshold() {
        this.discount = 20;
        this.threshold = 900;
    }

    @Override
    public double getTotal(Sale sale) {
        double totalSale = sale.gettotalSale();
        if (totalSale >= threshold) {
            // Aplica o desconto absoluto se o valor ultrapassar o limite
            return Math.max(0, totalSale - discount); // Garante que o valor não seja negativo
        } else {
            // Sem desconto se o valor não atingir o limite
            return totalSale;
        }
    }
}

// Classe Sale (representa uma venda)
class Sale {
    private double totalSale;

    public Sale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double gettotalSale() {
        return totalSale;
    }
}

// Factory para criar estratégias de desconto
class PricingStrategyFactory {
    private static PricingStrategyFactory instance;

    // Construtor privado para garantir Singleton
    private PricingStrategyFactory() {}

    // Método para obter a instância única da fábrica
    public static PricingStrategyFactory getInstance() {
        if (instance == null) {
            synchronized (PricingStrategyFactory.class) {
                if (instance == null) {
                    instance = new PricingStrategyFactory();
                }
            }
        }
        return instance;
    }

    // Método para criar uma estratégia de desconto com base no nome da classe
    public ISalePricingStrategy getSalePricingStrategy() throws Exception {
        String className = System.getProperty("salepricingstrategy.class.name");
        if (className == null || className.isEmpty()) {
            throw new IllegalArgumentException("Property 'salepricingstrategy.class.name' is not set.");
        }
        return (ISalePricingStrategy) Class.forName(className).getDeclaredConstructor().newInstance();
    }
}

// Classe principal para execução
public class Main {
    public static void main(String[] args) {
        try {
            // Obter a instância única da fábrica
            PricingStrategyFactory factory = PricingStrategyFactory.getInstance();

            // Criar uma estratégia de desconto usando a fábrica
            ISalePricingStrategy strategy = factory.getSalePricingStrategy();

            // Criar vendas com diferentes valores iniciais
            Sale sale1 = new Sale(1000); // Venda com valor total de 1000
            Sale sale2 = new Sale(700);  // Venda com valor total de 700

            // Calcular o total final com a estratégia criada pela fábrica
            System.out.println("Valor final com desconto venda 1 (1000): " + strategy.getTotal(sale1));
            System.out.println("Valor final com desconto venda 2 (700): " + strategy.getTotal(sale2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}