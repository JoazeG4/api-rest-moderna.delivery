package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "db_estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String razaoSocial;
    @Column(length = 14 ,nullable = false)
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private Set<Cardapio> cardapios = new HashSet<>();

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos = new HashSet<>();

}
