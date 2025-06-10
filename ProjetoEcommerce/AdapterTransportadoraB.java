public class AdapterTransportadoraB implements ITransportadoraAdapter {
    private TransportadoraB b = new TransportadoraB();

    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return b.freteSimples(dimensoes, destino);
    }

    public String gerarEtiqueta(String pedidoId) {
        return b.gerarDoc(pedidoId);
    }

    public String acompanharPedido(String codigoRastreamento) {
        return b.trackingStatus(codigoRastreamento);
    }

    public int tempoEntregaEstimada(String destino) {
        return 3;
    }
}
