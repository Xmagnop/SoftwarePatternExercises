public class TransportadoraAdapter {
    private ITransportadoraAPI api;

    public TransportadoraAdapter(ITransportadoraAPI api) {
        this.api = api;
    }

    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return api.calcularFrete(peso, dimensoes, destino);
    }

    public String gerarEtiqueta(String pedidoId) {
        return api.gerarEtiqueta(pedidoId);
    }

    public String acompanharPedido(String codigoRastreamento) {
        return api.acompanharPedido(codigoRastreamento);
    }
}
