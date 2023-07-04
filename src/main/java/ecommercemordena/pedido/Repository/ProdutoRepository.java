package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByCardapio_Id(Long cadarpioId);

    Optional<Produto> findByNomeProduto(String nomeProduto);

    @Transactional
    void deleteByNomeProduto(String nomeProduto);
}
