class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {
    private final double discount;
    private final double threshold;

    public AbsoluteDiscountOverThresholdPricingStrategy() {
        this.discount = 250;
        this.threshold = 900;
    }

    @Override
    public double getTotal(Sale sale) {
        double totalSale = sale.getTotalSale();
        if (totalSale >= threshold) {
            // Aplica o desconto absoluto se o valor ultrapassar o limite
            return Math.max(0, totalSale - discount); // Garante que o valor não seja negativo
        } else {
            // Sem desconto se o valor não atingir o limite
            return totalSale;
        }
    }
}