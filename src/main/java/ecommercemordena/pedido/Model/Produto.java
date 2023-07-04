package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "db_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome_do_produto", nullable = false)
    private String nomeProduto;
    @Column(nullable = false)
    private String descricao;
    @Column(name = "valor R$", length = 15, nullable = false)
    private Double valor;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cardapio_id")
    private Cardapio cardapio;
}
