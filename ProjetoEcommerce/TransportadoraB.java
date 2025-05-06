public class TransportadoraB implements ITransportadoraAPI {
    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return (dimensoes[0] + dimensoes[2]) * 8;
    }

    public String gerarEtiqueta(String pedidoId) {
        return "Etiqueta-B-" + pedidoId;
    }

    public String acompanharPedido(String codigoRastreamento) {
        return "B: Em trânsito";
    }
}
