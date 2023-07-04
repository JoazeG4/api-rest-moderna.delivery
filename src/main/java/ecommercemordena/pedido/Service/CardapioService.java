package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Cardapio;
import ecommercemordena.pedido.Repository.CardapioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardapioService {

    private CardapioRepository cardapioRepository;

    public Cardapio salvarCardapio(Cardapio cardapio) throws Exception {
        var cardapioAtual = cardapioRepository.findByNomeCardapio(cardapio.getNomeCardapio());

        if(cardapioAtual.isEmpty()) {
            return cardapioRepository.save(cardapio);
        }
        throw new Exception("Cardapio não existe!");
    }

    public Cardapio atualizarCardapioNome(String nomeCardapio, Cardapio cardapio) throws Exception{
        var cardapioAtual = cardapioRepository.findByNomeCardapio(nomeCardapio).orElseThrow(() -> new Exception("Cardapio não existe"));
        var cardapioNovo = cardapioRepository.findByNomeCardapio(cardapio.getNomeCardapio());

        if(Objects.equals(cardapioAtual.getNomeCardapio(), cardapio.getNomeCardapio()) || cardapioNovo.isEmpty()) {
            BeanUtils.copyProperties(cardapio, cardapioAtual, "id");
            return cardapioRepository.save(cardapioAtual);
        }
        throw new Exception("Cardapio já existe");
    }

    public List<Cardapio> listarTodosCardapios() throws Exception{
        var cardapioAtuais = cardapioRepository.findAll().isEmpty();

        if(cardapioAtuais) {
            throw new Exception("Não existe cardapios");
        }
        return cardapioRepository.findAll();
    }

    public Optional<Cardapio> listarCardapioNome(String nomeCardapio) throws Exception{
        return Optional.ofNullable(cardapioRepository.findByNomeCardapio(nomeCardapio)
                .orElseThrow(() -> new Exception("Cardapio não existe")));
    }

    public Void excluirTodosCardapios() throws Exception{
        var cardapioAtuais = cardapioRepository.findAll().isEmpty();

        if(cardapioAtuais) {
            throw new Exception("Não existe cardapios!");
        }
        cardapioRepository.deleteAll();
        return null;
    }

    public Void excluirCardapioNome(String nomeCardapio) throws Exception{
        cardapioRepository.findByNomeCardapio(nomeCardapio).orElseThrow(() -> new Exception("Cardapio não existe!"));
        cardapioRepository.deleteByNomeCardapio(nomeCardapio);
        return null;
    }
}
