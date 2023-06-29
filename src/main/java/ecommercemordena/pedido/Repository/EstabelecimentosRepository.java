package ecommercemordena.pedido.Repository;

import ecommercemordena.pedido.Model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentosRepository  extends JpaRepository<Estabelecimento, Long> {


    Optional<Estabelecimento> findByRazaoSocial(String razaoSocial);

}
