public class TransportadoraA {
    public double calcularCusto(double peso, double largura, double altura, double profundidade, String destino) {
        return peso * 10;
    }

    public String criarEtiqueta(String pedidoId) {
        return "Etiqueta-A-" + pedidoId;
    }

    public String rastrear(String codigo) {
        return "A: Entregue";
    }
}
