public class Main {
    public static void main(String[] args) {
        SistemaPedidosFacade sistema = new SistemaPedidosFacade();

        // Dados de teste: peso, dimensões (largura, altura, profundidade)
        double[][] pesosEDimensoes = {
            {5.0, 15.0, 40.0}, // pedido 1
            {13.0, 35.0, 7.0},   // pedido 2
            {20.0, 10.0, 5.0}  // pedido 3
        };
        String[] destinos = {"12345-678", "87654-321", "11223-445"};
        String[] pedidos = {"P1", "P2", "P3"};
        String[] rastreamentos = {"R1", "R2", "R3"};

        for (int i = 0; i < pedidos.length; i++) {
            double peso = pesosEDimensoes[i][0];
            double[] dimensoes = {pesosEDimensoes[i][1], pesosEDimensoes[i][2], 10.0};
            String destino = destinos[i];

            System.out.println("Pedido " + pedidos[i] + ":");
            System.out.println("- Melhor Frete: R$" + sistema.calcularFrete(peso, dimensoes, destino));
            System.out.println("- Etiqueta: " + sistema.gerarEtiqueta(pedidos[i], peso, dimensoes, destino));
            System.out.println("- Status: " + sistema.acompanharPedido(rastreamentos[i], peso, dimensoes, destino));
            System.out.println();
        }
    }
}
