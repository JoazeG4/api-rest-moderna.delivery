package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

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

}
