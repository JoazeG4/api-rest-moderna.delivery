package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
