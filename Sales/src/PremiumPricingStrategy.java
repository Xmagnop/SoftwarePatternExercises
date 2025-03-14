public class PremiumPricingStrategy implements ISalePricingStrategy {
    @Override
    public double getTotal(Sale sale) {
        double totalSale = sale.getTotalSale();
        System.out.println("Aplicando estratégia de preço premium.");
        return totalSale;
    }
}
