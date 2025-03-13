public class PricingStrategyFactory {
    private static PricingStrategyFactory instance;

    // Private constructor to prevent instantiation
    private PricingStrategyFactory() {}

    // Método que retorna a instância única da fábrica
    public static PricingStrategyFactory getInstance() {
        if (instance == null) {
            instance = new PricingStrategyFactory();
        }
        return instance;
    }

    // Método que cria a estratégia de preço com base na configuração externa
    public ISalesPricingStrategy getSalesPricingStrategy() {
        try {
            String className = System.getProperty("salepricingstrategy.class.name");
            if (className == null || className.isEmpty()) {
                throw new IllegalArgumentException("O nome da classe não foi fornecido.");
            }
            // Instancia a classe dinamicamente
            Class<?> strategyClass = Class.forName(className);
            return (ISalesPricingStrategy) strategyClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar a estratégia de precificação", e);
        }
    }
}
