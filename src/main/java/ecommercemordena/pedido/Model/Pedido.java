package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "db_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String total;
    private String produto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
