public class TransportadoraB {
    public double freteSimples(double[] dimensoes, String destino) {
        return dimensoes[0] * 10;
    }

    public String gerarDoc(String pedidoId) {
        return "Etiqueta-B-" + pedidoId;
    }

    public String trackingStatus(String codigo) {
        return "B: Em trânsito";
    }
}
