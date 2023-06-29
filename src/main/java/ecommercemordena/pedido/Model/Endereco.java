package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(length = 4, nullable = false)
    private String numero;
    @Column(length = 8, nullable = false)
    private String cep;
    @Column(length = 50, nullable = false)
    private String bairro;
    @Column(length = 50, nullable = false)
    private String cidade;
    @Column(length = 2, nullable = false)
    private String uf;
    @Column(nullable = false)
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
