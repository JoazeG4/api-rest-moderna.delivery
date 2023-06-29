package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Categoria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNomeCategoria(String nomeCategoria);
    @Transactional
    void deleteByNomeCategoria(String nomeCategoria);
}
