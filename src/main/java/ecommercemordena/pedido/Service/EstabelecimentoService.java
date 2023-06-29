package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Estabelecimento;
import ecommercemordena.pedido.Repository.EstabelecimentosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private EstabelecimentosRepository estabelecimentosRepository;

    public Estabelecimento salvarEstabelecimento(Estabelecimento estabelecimento) throws Exception{
        var estabelecimentoSalvo = estabelecimentosRepository.findByRazaoSocial(estabelecimento.getCnpj());

        if(estabelecimentoSalvo.isEmpty()){
            return estabelecimentosRepository.save(estabelecimento);
        }
        throw new Exception("Cliente existente!");
    }
}
