public class SistemaPedidosFacade {
    private TransportadoraAdapter[] adapters;

    public SistemaPedidosFacade() {
        adapters = new TransportadoraAdapter[] {
            new TransportadoraAdapter(new TransportadoraA()),
            new TransportadoraAdapter(new TransportadoraB()),
            new TransportadoraAdapter(new TransportadoraC())
        };
    }

    private TransportadoraAdapter escolherMelhorTransportadora(double peso, double[] dimensoes, String destino) {
        TransportadoraAdapter melhor = adapters[0];
        double melhorCusto = melhor.calcularFrete(peso, dimensoes, destino);
        int melhorTempo = melhor.tempoEntregaEstimada(destino);

        for (TransportadoraAdapter adapter : adapters) {
            double frete = adapter.calcularFrete(peso, dimensoes, destino);
            int tempo = adapter.tempoEntregaEstimada(destino);
            if (frete < melhorCusto || (frete == melhorCusto && tempo < melhorTempo)) {
                melhor = adapter;
                melhorCusto = frete;
                melhorTempo = tempo;
            }
        }

        return melhor;
    }

    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return escolherMelhorTransportadora(peso, dimensoes, destino).calcularFrete(peso, dimensoes, destino);
    }

    public String gerarEtiqueta(String pedidoId, double peso, double[] dimensoes, String destino) {
        return escolherMelhorTransportadora(peso, dimensoes, destino).gerarEtiqueta(pedidoId);
    }

    public String acompanharPedido(String codigoRastreamento, double peso, double[] dimensoes, String destino) {
        return escolherMelhorTransportadora(peso, dimensoes, destino).acompanharPedido(codigoRastreamento);
    }
}
