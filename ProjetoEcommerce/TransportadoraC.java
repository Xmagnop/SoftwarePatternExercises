public class TransportadoraC {
    public String calcularFreteJson(double peso, double[] dimensoes, String destino) {
        double valor = dimensoes[1] * 10;
        return "{\"frete\": " + valor + "}";
    }

    public String etiquetaJSON(String pedidoId) {
        return "{\"etiqueta\": \"Etiqueta-C-" + pedidoId + "\"}";
    }

    public String statusJSON(String codigo) {
        return "{\"status\": \"C: Aguardando retirada\"}";
    }
}
