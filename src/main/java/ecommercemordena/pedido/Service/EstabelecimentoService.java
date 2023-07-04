package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Estabelecimento;
import ecommercemordena.pedido.Repository.EstabelecimentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private EstabelecimentoRepository estabelecimentoRepository;

    public Estabelecimento salvarEstabelecimento(Estabelecimento estabelecimento) throws Exception {
        var razaoSocialAtual = estabelecimentoRepository.findByRazaoSocial(estabelecimento.getRazaoSocial());
        var cnpjlAtual = estabelecimentoRepository.findByCnpj(estabelecimento.getCnpj());

        if(razaoSocialAtual.isEmpty() && cnpjlAtual.isEmpty()) {
            return estabelecimentoRepository.save(estabelecimento);
        }
        throw new Exception("Estabelecimento existente!");
    }

    public Estabelecimento atualizarEstabelecimentoRazaoSocial(String razaoSocial, Estabelecimento estabelecimento) throws Exception{
        var estabelecimentoAtual = estabelecimentoRepository.findByRazaoSocial(razaoSocial).orElseThrow(() -> new Exception("Estabelecimento não encontrato!"));
        var estabelecimentoNovo = estabelecimentoRepository.findByRazaoSocial(estabelecimento.getRazaoSocial());

        if(Objects.equals(estabelecimentoAtual.getRazaoSocial(), estabelecimento.getRazaoSocial()) || estabelecimentoNovo.isEmpty()) {
            BeanUtils.copyProperties(estabelecimento, estabelecimentoAtual, "id");
            return estabelecimentoRepository.save(estabelecimentoAtual);
        }
        throw new Exception("Estabelecimento já existente!");
    }

    public List<Estabelecimento> listarTodosEstabelecimentos() throws Exception{
        var contatosAtuais = estabelecimentoRepository.findAll().isEmpty();

        if(contatosAtuais) {
            throw new Exception("Não existe estabelecimentos");
        }
        return estabelecimentoRepository.findAll();
    }

    public Optional<Estabelecimento> listarEstabelecimentoRazaoSocial(String razaoSocial) throws Exception{
        return Optional.ofNullable(estabelecimentoRepository.findByRazaoSocial(razaoSocial)
                .orElseThrow(() -> new Exception("Estabelecimento inexistente!")));
    }

    public Void excluirTodosEstabelecimentos() throws Exception{
        var contatosAtuais = estabelecimentoRepository.findAll().isEmpty();

        if(contatosAtuais) {
            throw new Exception("Não existe estabelecimentos");
        }
        estabelecimentoRepository.deleteAll();
        return null;
    }

    public Void excluirEstabelecimentoRazaoSocial(String razaoSocial) throws Exception{
        estabelecimentoRepository.findByRazaoSocial(razaoSocial).orElseThrow(() -> new Exception("Estabelecimento inexistente!"));
        estabelecimentoRepository.deleteByRazaoSocial(razaoSocial);
        return null;
    }
}
