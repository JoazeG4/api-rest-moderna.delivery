package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "db_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_da_categoria", nullable = false)
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Set<Estabelecimento> estabelecimentos = new HashSet<>();

}
