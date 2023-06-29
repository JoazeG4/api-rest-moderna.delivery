package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Contato;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    Optional<Contato> findByNumero(String numero);
    Optional<Contato> findByEmail(String email);
    @Transactional
    void deleteByNumero(String numero);

}
