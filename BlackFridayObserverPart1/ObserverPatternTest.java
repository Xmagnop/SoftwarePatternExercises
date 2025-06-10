// Parte 1: Implementacao do padrao Observer
import java.util.ArrayList;
import java.util.List;

// Interface Observer (Cliente)
interface Observer {
    void update(List<String> promocoes);
}

// Interface Subject (Loja)
interface Subject {
    public void adicionarObserver(Observer cliente);
    
    public void removerObserver(Observer cliente);
    
    public void notificarObservers();
}

// Classe concreta Observer (Cliente)
class Cliente implements Observer {
    private String nome;
    
    public Cliente(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void update(List<String> promocoes) {
        System.out.println("Cliente " + nome + " foi notificado sobre as promoções. Segue lista abaixo:!");
        for (String produto : promocoes) {
            System.out.println("Produto: " + produto + "!");
        }
    }
}

// Classe Concreta Subject (Loja)
class Loja implements Subject {
    private List<Observer> clientes;
    private List<String> promocoes;

    public Loja() {
        clientes = new ArrayList<Observer>();
        promocoes = new ArrayList<String>();
    }
    
    @Override
    public void adicionarObserver(Observer cliente) {
        clientes.add(cliente);
    }
    
    @Override
    public void removerObserver(Observer cliente) {
        clientes.remove(cliente);
    }
    
    @Override
    public void notificarObservers() {
        for (Observer cliente : clientes) {
            cliente.update(promocoes);
        }
    }
    

    public void promocoesMudaram() {
        notificarObservers();
    }


    public void adicionarPromocao(String produto) {
        promocoes.add(produto);
        promocoesMudaram();
    }

    public void removerPromocao(String produto) {
        promocoes.remove(produto);
        promocoesMudaram();
    }
}

// Teste do sistema
public class ObserverPatternTest {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");
        
        loja.adicionarObserver(cliente1);
        loja.adicionarObserver(cliente2);
        
        loja.adicionarPromocao("SmartPhone X");
        loja.adicionarPromocao("Televisão");

        loja.removerPromocao("SmartPhone X");
    }
}