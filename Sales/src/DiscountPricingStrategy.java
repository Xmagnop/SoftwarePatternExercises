public class DiscountPricingStrategy implements ISalesPricingStrategy {
    @Override
    public void applyPricing() {
        System.out.println("Aplicando estratégia de desconto.");
    }
}
