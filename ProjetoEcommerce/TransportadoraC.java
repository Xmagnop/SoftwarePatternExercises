public class TransportadoraC implements ITransportadoraAPI {
    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return dimensoes[1] * 10;
    }

    public String gerarEtiqueta(String pedidoId) {
        return "Etiqueta-C-" + pedidoId;
    }

    public String acompanharPedido(String codigoRastreamento) {
        return "C: Aguardando retirada";
    }
}
