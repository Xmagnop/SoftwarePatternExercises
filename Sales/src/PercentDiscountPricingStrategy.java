public class PercentDiscountPricingStrategy implements ISalePricingStrategy {
    private final double percentage;

    public PercentDiscountPricingStrategy() {
        this.percentage = 15;
    }

    @Override
    public double getTotal(Sale sale) {
        double totalSale = sale.getTotalSale();
        double discountAmount = totalSale * (percentage / 100);
        return totalSale - discountAmount; // Aplica o desconto percentual
    }
}
