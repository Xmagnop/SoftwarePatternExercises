public class PremiumPricingStrategy implements ISalesPricingStrategy {
    @Override
    public void applyPricing() {
        System.out.println("Aplicando estratégia de preço premium.");
    }
}
