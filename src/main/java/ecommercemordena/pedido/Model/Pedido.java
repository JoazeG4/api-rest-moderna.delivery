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
    private String cliente;
    private String total;
    private String produto;
}
