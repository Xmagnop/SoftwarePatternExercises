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

    public int tempoEntregaEstimada(String destino) {
        // Simulação de tempo de entrega estimado
        if (api instanceof TransportadoraA) return 5;  // 5 dias
        if (api instanceof TransportadoraB) return 3;  // 3 dias
        if (api instanceof TransportadoraC) return 4;  // 4 dias
        return Integer.MAX_VALUE;
    }
}
