package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Endereco;
import ecommercemordena.pedido.Repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) throws Exception{
        var enderecoAtual = enderecoRepository.findByCep(endereco.getCep());

        if(enderecoAtual.isEmpty()){
            return enderecoRepository.save(endereco);
        }
        throw new Exception("Endereco já existente!");
    }

    public Endereco atualizarEnderecoCep(String cep, Endereco endereco) throws Exception{
        var enderecoAtual = enderecoRepository.findByCep(cep).orElseThrow(() -> new Exception("Endereco não encontrado!"));
        var enderecoNovo = enderecoRepository.findByCep(endereco.getCep());

        if(Objects.equals(enderecoAtual.getCep(), endereco.getCep()) || enderecoNovo.isEmpty()) {
            BeanUtils.copyProperties(endereco, enderecoAtual, "id");
            return enderecoRepository.save(enderecoAtual);
        }
        throw new Exception("Endereco já existente!");
    }

    public List<Endereco> listarTodosEnderecos() throws Exception{
        var enderecoAtuais = enderecoRepository.findAll().isEmpty();

        if (enderecoAtuais){
            throw new Exception("Não existe enderecos salvos!");
        }
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> listarEnderecoCep(String cep) throws Exception{
        return Optional.ofNullable(enderecoRepository.findByCep(cep)
                .orElseThrow(() -> new Exception("Endereco não encontrado!")));
    }

    public Void excluirEnderecoCep(String cep) throws Exception{
        enderecoRepository.findByCep(cep).orElseThrow(() -> new Exception("Endereco não encontrado!"));
        enderecoRepository.deleteByCep(cep);
        return null;
    }

    public Void excluirTodosEnderecos() throws Exception{
        var enderecoAtuais = enderecoRepository.findAll().isEmpty();

        if (enderecoAtuais){
            throw new Exception("Não existe enderecos salvos!");
        }
        enderecoRepository.deleteAll();
        return null;
    }
}
