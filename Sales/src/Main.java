import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Caminho do arquivo que contém o nome da classe
        String classNameFromFile = readClassNameFromFile("/home/alexandre/cimatec/SoftwarePatternExercises/Sales/src/PricingStrategy.txt");

        if (classNameFromFile != null && !classNameFromFile.isEmpty()) {
            // Definindo o nome da classe da estratégia de preço
            System.setProperty("salepricingstrategy.class.name", classNameFromFile);

            // Obtendo a instância da fábrica
            PricingStrategyFactory factory = PricingStrategyFactory.getInstance();

            // Obtendo a estratégia de preço
            ISalePricingStrategy strategy = factory.getSalesPricingStrategy();

            // Criar vendas com diferentes valores iniciais
            Sale sale1 = new Sale(1000); // Venda com valor total de 1000
            Sale sale2 = new Sale(700);  // Venda com valor total de 700

            // Calcular o total final com a estratégia criada pela fábrica
            System.out.println("Valor final com desconto venda 1 (1000): " + strategy.getTotal(sale1));
            System.out.println("Valor final com desconto venda 2 (700): " + strategy.getTotal(sale2));
        } else {
            System.out.println("Nenhum nome de classe válido encontrado no arquivo.");
        }
    }

    // Método para ler o nome da classe de um arquivo
    private static String readClassNameFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.readLine(); // Lê a primeira linha do arquivo
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
