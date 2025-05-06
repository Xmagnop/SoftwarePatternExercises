public class AdapterTransportadoraC implements ITransportadoraAdapter {
    private TransportadoraC c = new TransportadoraC();

    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        String json = c.calcularFreteJson(peso, dimensoes, destino);
        return Double.parseDouble(json.replaceAll("[^0-9.]", ""));
    }

    public String gerarEtiqueta(String pedidoId) {
        String json = c.etiquetaJSON(pedidoId);
        return json.replaceAll("[^a-zA-Z0-9\\-]", "");
    }

    public String acompanharPedido(String codigoRastreamento) {
        String json = c.statusJSON(codigoRastreamento);
        return json.replaceAll("[^a-zA-Z: ]", "");
    }

    public int tempoEntregaEstimada(String destino) {
        return 4;
    }
}
