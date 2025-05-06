public class TransportadoraA implements ITransportadoraAPI {
    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return peso * 10;
    }

    public String gerarEtiqueta(String pedidoId) {
        return "Etiqueta-A-" + pedidoId;
    }

    public String acompanharPedido(String codigoRastreamento) {
        return "A: Entregue";
    }
}
