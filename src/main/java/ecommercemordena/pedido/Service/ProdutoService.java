package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Produto;
import ecommercemordena.pedido.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) throws Exception {
            return produtoRepository.save(produto);
    }

    public Produto atualizarProdutoNome(String nomeProduto, Produto produto) throws Exception{
        var produtoAtual = produtoRepository.findByNomeProduto(nomeProduto).orElseThrow(() -> new Exception("Produto não existe"));
        var produtoNovo = produtoRepository.findByNomeProduto(produto.getNomeProduto());

        if(Objects.equals(produtoAtual.getNomeProduto(), produto.getNomeProduto()) || produtoNovo.isEmpty()) {
            BeanUtils.copyProperties(produto, produtoAtual, "id");
            return produtoRepository.save(produtoAtual);
        }
        throw new Exception("Produto já existe");
    }

    public List<Produto> listarTodosProdutos() throws Exception{
        var produtoAtual = produtoRepository.findAll().isEmpty();

        if(produtoAtual) {
            throw new Exception("Não existe produtos");
        }
        return produtoRepository.findAll();
    }

    public Optional<Produto> listarProdutoNome(String nomeProduto) throws Exception{
        return Optional.ofNullable(produtoRepository.findByNomeProduto(nomeProduto)
                .orElseThrow(() -> new Exception("Produto não existe")));
    }

    public Void excluirTodosProdutos() throws Exception{
        var produtoAtual = produtoRepository.findAll().isEmpty();

        if(produtoAtual) {
            throw new Exception("Não existe produtos!");
        }
        produtoRepository.deleteAll();
        return null;
    }

    public Void excluirProdutoNome(String nomeProduto) throws Exception{
        produtoRepository.findByNomeProduto(nomeProduto).orElseThrow(() -> new Exception("Produto não existe!"));
        produtoRepository.deleteByNomeProduto(nomeProduto);
        return null;
    }
}
