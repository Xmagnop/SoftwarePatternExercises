public interface ITransportadoraAdapter {
    double calcularFrete(double peso, double[] dimensoes, String destino);
    String gerarEtiqueta(String pedidoId);
    String acompanharPedido(String codigoRastreamento);
}