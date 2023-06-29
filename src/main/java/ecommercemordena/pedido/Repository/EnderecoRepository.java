package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Endereco;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByCep(String endereco);
    @Transactional
    void deleteByCep(String cep);
}