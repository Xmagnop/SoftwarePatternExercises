// Parte 2: Implementacao do padrao Publisher-Subscriber
import java.util.*;

// Interface Subscriber (Cliente)
interface Subscriber {
    void update(String departamento, List<String> promocoes);
}

// Interface Publisher (Loja)
interface Publisher {
    void adicionarSubscriber(String departamento, Subscriber cliente);
    void removerSubscriber(String departamento, Subscriber cliente);
    void notificarSubscribers(String departamento);
}

// Classe concreta Subscriber (Cliente)
class Cliente implements Subscriber {
    private String nome;
    private Set<String> interesses;
    
    public Cliente(String nome) {
        this.nome = nome;
        this.interesses = new HashSet<>();
    }
    
    public void adicionarInteresse(String departamento) {
        interesses.add(departamento);
    }
    
    @Override
    public void update(String departamento, List<String> promocoes) {
        if (interesses.contains(departamento)) {
            System.out.println("Cliente " + nome + " foi notificado sobre as promoções no departamento " + departamento + ". Lista de promoções:");
            for (String produto : promocoes) {
                System.out.println("- " + produto);
            }
        }
    }
}

// Classe concreta Publisher (Loja)
class Loja implements Publisher {
    private Map<String, List<Subscriber>> assinantesPorDepartamento;
    private Map<String, List<String>> promocoesPorDepartamento;

    public Loja() {
        assinantesPorDepartamento = new HashMap<>();
        promocoesPorDepartamento = new HashMap<>();
    }
    
    @Override
    public void adicionarSubscriber(String departamento, Subscriber cliente) {
        assinantesPorDepartamento.computeIfAbsent(departamento, k -> new ArrayList<>()).add(cliente);
    }
    
    @Override
    public void removerSubscriber(String departamento, Subscriber cliente) {
        assinantesPorDepartamento.getOrDefault(departamento, new ArrayList<>()).remove(cliente);
    }
    
    @Override
    public void notificarSubscribers(String departamento) {
        List<Subscriber> assinantes = assinantesPorDepartamento.getOrDefault(departamento, new ArrayList<>());
        List<String> promocoes = promocoesPorDepartamento.getOrDefault(departamento, new ArrayList<>());
        for (Subscriber cliente : assinantes) {
            cliente.update(departamento, promocoes);
        }
    }
    
    public void adicionarPromocao(String departamento, String produto) {
        promocoesPorDepartamento.computeIfAbsent(departamento, k -> new ArrayList<>()).add(produto);
        notificarSubscribers(departamento);
    }
    
    public void removerPromocao(String departamento, String produto) {
        promocoesPorDepartamento.getOrDefault(departamento, new ArrayList<>()).remove(produto);
        notificarSubscribers(departamento);
    }
}

// Teste do sistema
public class PublisherSubscriberTest {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");
        
        cliente1.adicionarInteresse("Eletrônicos");
        cliente2.adicionarInteresse("Roupas");
        
        loja.adicionarSubscriber("Eletrônicos", cliente1);
        loja.adicionarSubscriber("Roupas", cliente2);
        
        loja.adicionarPromocao("Eletrônicos", "Smartphone X");
        loja.adicionarPromocao("Roupas", "Jaqueta de Couro");

        loja.removerPromocao("Eletrônicos", "Smartphone X");
    }
}