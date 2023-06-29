package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db_contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 9, nullable = false)
    private String numero;
    @Column(length = 2, nullable = false)
    private String ddd;
    @Column(length = 35, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}