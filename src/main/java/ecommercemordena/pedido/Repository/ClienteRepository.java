package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Optional<Cliente> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);
}
