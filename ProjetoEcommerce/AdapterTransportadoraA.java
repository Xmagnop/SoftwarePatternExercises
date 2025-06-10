public class AdapterTransportadoraA implements ITransportadoraAdapter {
    private TransportadoraA a = new TransportadoraA();

    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return a.calcularCusto(peso, dimensoes[0], dimensoes[1], dimensoes[2], destino);
    }

    public String gerarEtiqueta(String pedidoId) {
        return a.criarEtiqueta(pedidoId);
    }

    public String acompanharPedido(String codigoRastreamento) {
        return a.rastrear(codigoRastreamento);
    }

    public int tempoEntregaEstimada(String destino) {
        return 5;
    }
}
