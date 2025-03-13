public class App {
    public static void main(String[] args) {
        // Definindo qual classe de estratégia será usada
        System.setProperty("salepricingstrategy.class.name", "PremiumPricingStrategy");

        // Obtendo a instância da fábrica
        PricingStrategyFactory factory = PricingStrategyFactory.getInstance();

        // Obtendo a estratégia de preço
        ISalesPricingStrategy strategy = factory.getSalesPricingStrategy();

        // Aplicando a estratégia
        strategy.applyPricing();
    }
}
