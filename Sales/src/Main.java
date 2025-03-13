import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Caminho do arquivo que contém o nome da classe
        String classNameFromFile = readClassNameFromFile("C:/Users/uig32599/Documents/Git/SoftwarePatternExercises/Sales/src/PricingStrategy.txt");

        if (classNameFromFile != null && !classNameFromFile.isEmpty()) {
            // Definindo o nome da classe da estratégia de preço
            System.setProperty("salepricingstrategy.class.name", classNameFromFile);

            // Obtendo a instância da fábrica
            PricingStrategyFactory factory = PricingStrategyFactory.getInstance();

            // Obtendo a estratégia de preço
            ISalesPricingStrategy strategy = factory.getSalesPricingStrategy();

            // Aplicando a estratégia
            strategy.applyPricing();
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
