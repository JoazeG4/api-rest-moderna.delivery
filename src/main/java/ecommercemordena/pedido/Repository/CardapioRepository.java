package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Cardapio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

    Optional<Cardapio> findByNomeCardapio(String nomeProduto);
    @Transactional
    void deleteByNomeCardapio(String nomeProduto);
}

