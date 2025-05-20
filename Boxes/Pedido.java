import java.util.ArrayList;
import java.util.List;

// Interface comum
interface Item {
    double getPreco();
}

// Produto simples
class Produto implements Item {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}

// Caixa que pode conter produtos ou outras caixas
class Caixa implements Item {
    private String nome;
    private List<Item> itens = new ArrayList<>();
    private double custoEmbalagem;

    public Caixa(String nome, double custoEmbalagem) {
        this.nome = nome;
        this.custoEmbalagem = custoEmbalagem;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    @Override
    public double getPreco() {
        double total = custoEmbalagem;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        return nome + " (com embalagem de R$" + custoEmbalagem + ")";
    }
}

// Exemplo de uso
public class Pedido {
    public static void main(String[] args) {
        Produto p1 = new Produto("Livro", 50);
        Produto p2 = new Produto("Caneta", 5);
        Produto p3 = new Produto("Caderno", 30);

        Caixa caixa1 = new Caixa("Caixa Pequena", 2);
        caixa1.adicionarItem(p2);
        caixa1.adicionarItem(p3);

        Caixa caixa2 = new Caixa("Caixa Grande", 5);
        caixa2.adicionarItem(p1);
        caixa2.adicionarItem(caixa1); // Caixa dentro de caixa

        System.out.println("Preço total do pedido: R$" + caixa2.getPreco());
    }
}
