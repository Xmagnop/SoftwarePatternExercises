public class SistemaPedidosFacade {
    private ITransportadoraAdapter[] adapters;

    public SistemaPedidosFacade() {
        adapters = new ITransportadoraAdapter[] {
            new AdapterTransportadoraA(),
            new AdapterTransportadoraB(),
            new AdapterTransportadoraC()
        };
    }

    private ITransportadoraAdapter escolherMelhor(double peso, double[] dimensoes, String destino) {
        ITransportadoraAdapter melhor = adapters[0];
        double melhorFrete = melhor.calcularFrete(peso, dimensoes, destino);

        for (ITransportadoraAdapter adapter : adapters) {
            double frete = adapter.calcularFrete(peso, dimensoes, destino);

            if (frete < melhorFrete) {
                melhor = adapter;
                melhorFrete = frete;
            }
        }

        return melhor;
    }

    public double calcularFrete(double peso, double[] dimensoes, String destino) {
        return escolherMelhor(peso, dimensoes, destino).calcularFrete(peso, dimensoes, destino);
    }

    public String gerarEtiqueta(String pedidoId, double peso, double[] dimensoes, String destino) {
        return escolherMelhor(peso, dimensoes, destino).gerarEtiqueta(pedidoId);
    }

    public String acompanharPedido(String codigo, double peso, double[] dimensoes, String destino) {
        return escolherMelhor(peso, dimensoes, destino).acompanharPedido(codigo);
    }
}
