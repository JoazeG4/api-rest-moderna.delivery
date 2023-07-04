package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Slf4j
@Table(name = "db_cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome_do_cardapio", nullable = false)
    private String nomeCardapio;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL)
    private Set<Produto> produtos = new HashSet<>();

}
