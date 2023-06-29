package ecommercemordena.pedido.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "db_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(name = "data_de_nascimento", nullable = false)
    private String dataNascimento;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Contato> contatos = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos = new HashSet<>();

}
