package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Estabelecimento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    Optional<Estabelecimento> findByRazaoSocial(String razaoSocial);

    Optional<Estabelecimento> findByCnpj(String cnpj);
    @Transactional
    void deleteByRazaoSocial(String razaoSocial);
}
