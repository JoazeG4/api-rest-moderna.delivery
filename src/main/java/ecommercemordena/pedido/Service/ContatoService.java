package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Contato;
import ecommercemordena.pedido.Repository.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContatoService {

    private ContatoRepository contatoRepository;

    public Contato salvarContato(Contato contato) throws Exception {
        var numeroAtual = contatoRepository.findByNumero(contato.getNumero());
        var emailAtual = contatoRepository.findByEmail(contato.getEmail());

        if(numeroAtual.isEmpty() && emailAtual.isEmpty()) {
            return contatoRepository.save(contato);
        }
        throw new Exception("Contato existente!");
    }

    public Contato atualizarContatoPorNumero(String numero, Contato contato) throws Exception{
        var contatoAtual = contatoRepository.findByNumero(numero).orElseThrow(() -> new Exception("Contato não encontrado!"));
        var contatoNovo = contatoRepository.findByNumero(contato.getNumero());

        if(Objects.equals(contatoAtual.getNumero(), contato.getNumero()) || contatoNovo.isEmpty()) {
            BeanUtils.copyProperties(contato, contatoAtual, "id");
            return contatoRepository.save(contatoAtual);
        }
        throw new Exception("Contato já existente!");
    }

    public List<Contato> listarTodosContatos() throws Exception{
        var contatosAtuais = contatoRepository.findAll().isEmpty();

        if(contatosAtuais) {
            throw new Exception("Não existe contatos");
        }
        return contatoRepository.findAll();
    }

    public Optional<Contato> listarContatoPorNumero(String numero) throws Exception{
        return Optional.ofNullable(contatoRepository.findByNumero(numero).orElseThrow(() -> new Exception("Contato inexistente!")));
    }

    public Void excluirTodosContatos() throws Exception{
        var contatosAtuais = contatoRepository.findAll().isEmpty();

        if(contatosAtuais) {
            throw new Exception("Não existe contatos");
        }
        contatoRepository.deleteAll();
        return null;
    }

    public Void excluirContatoPorNumero(String numero) throws Exception{
        contatoRepository.findByNumero(numero).orElseThrow(() -> new Exception("Contato inexistente!"));
        contatoRepository.deleteByNumero(numero);
        return null;
    }
}
