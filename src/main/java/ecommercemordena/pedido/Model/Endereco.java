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
    private String rua;
    private String numero;
    @Column(length = 8)
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
}
